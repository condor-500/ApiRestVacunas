package com.jefferson.apijefferson1.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.jefferson.apijefferson1.entity.EmpleadoE;
import com.jefferson.apijefferson1.entity.VacunaE;
import com.jefferson.apijefferson1.services.IEmpleadoS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmpleadoRestController {

  @Autowired
  private IEmpleadoS empleadoS;

  @GetMapping("/empleados")
  public List<EmpleadoE> all() {
    return empleadoS.findAll();
  }

  @GetMapping("/empleados/{id}")
  public ResponseEntity<?> EmpleadoId(@PathVariable Long id) {
    EmpleadoE empleado = null;
    Map<String, Object> mensaje = new HashMap<>();
    try {
      empleado = empleadoS.findById(id);
      if (empleado == null) {
        mensaje.put("Mensaje", "No se encuentra registrado el empleado : ".concat(id.toString()));
        return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.NOT_FOUND);
      }

    } catch (DataAccessException e) {
      mensaje.put("Mensaje ", "Error a consultar en la base de datos ");
      mensaje.put("Error ", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<EmpleadoE>(empleado, HttpStatus.OK);
  }

  @PostMapping("/empleados")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<?> crearEmpleado(@Valid @RequestBody EmpleadoE empleado,
      BindingResult resl) {

    EmpleadoE empleadoN = null;
    Map<String, Object> mensaje = new HashMap<>();

    if (resl.hasErrors()) {
      List<String> err = resl.getAllErrors()
          .stream()
          .map(errs -> "El campo ".concat(((FieldError) errs).getField()).concat(" ").concat(errs.getDefaultMessage()))
          .collect(Collectors.toList());

      mensaje.put("Error ", err);
      return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.BAD_REQUEST);
    }
    try {
      empleadoN = empleadoS.save(empleado);
    } catch (DataAccessException e) {
      mensaje.put("Mensaje ", "No se puede realizar el ingreso");
      mensaje.put("Error ", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    mensaje.put("mensaje", " Registro creado con exito");
    mensaje.put("cliente", empleadoN);
    return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @PutMapping("/empleados/{id}")
  public ResponseEntity<?> actualizarEmpleado(@Valid @RequestBody EmpleadoE empleado, @PathVariable Long id) {

    System.out.println("--hola--" + empleado.getVacunas().get(0).toString());
    EmpleadoE empleadoA = empleadoS.findById(id);
    EmpleadoE empleadoU = null;

    Map<String, Object> mensaje = new HashMap<>();

    if (empleadoA == null) {
      mensaje.put("Mensaje", "error no editar el usuario");
      return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.NOT_FOUND);
    }

    try {
      empleadoA.setCedula(empleado.getCedula());
      empleadoA.setNombre(empleado.getNombre());
      empleadoA.setApellido(empleado.getApellido());
      empleadoA.setMail(empleado.getMail());
      empleadoA.setDireccion(empleado.getDireccion());
      empleadoA.setFechaNacimiento(empleado.getFechaNacimiento());
      empleadoA.setEstadoVacunacion(empleado.getEstadoVacunacion());
      empleadoA.setTelefono(empleado.getTelefono());
      VacunaE vacuna = new VacunaE();
      vacuna.setIdEmpleadoVacuna(empleado.getId());
      vacuna.setNumeroVacuna(empleado.getVacunas().get(0).getNumeroVacuna());
      vacuna.setFechaVacuna(empleado.getVacunas().get(0).getFechaVacuna());
      vacuna.setTipoVacuna(empleado.getVacunas().get(0).getTipoVacuna());

      empleadoA.addVacuna(vacuna);

      empleadoU = empleadoS.save(empleadoA);

    } catch (DataAccessException e) {
      mensaje.put("Mensaje ", "Error actualizar");
      mensaje.put("Error ", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    mensaje.put("Mensaje ", "Registro actualizado");
    mensaje.put("Cliente ", empleadoU);
    return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.CREATED);

  }

  @DeleteMapping(value = "/empleados/{id}")
  public ResponseEntity<?> eliminar(@PathVariable Long id) {
    Map<String, Object> mensaje = new HashMap<>();

    try {
      empleadoS.delete(id);
    } catch (DataAccessException e) {
      mensaje.put("Mensaje ", "Error de Acceso a BD ");
      mensaje.put("Error ", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    mensaje.put("Mensaje", "Registro Eliminado");
    return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.OK);

  }

  @GetMapping("/estadoVacuna")
  public ResponseEntity<?> getEstadoVacuna(String estado) {
    List<EmpleadoE> empleado = null;
    empleado = empleadoS.findByEstadoVacunacion(estado);
    Map<String, Object> mensaje = new HashMap<>();
    if (empleado.size() == 0) {
      mensaje.put("Mensaje", "No existen Datos para la busqueda realizada");
      return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<List<EmpleadoE>>(empleado, HttpStatus.OK);

  }

  @GetMapping("/tipoVacuna")
  public ResponseEntity<?> getTipoVacuna(String tipo) {
    List<EmpleadoE> empleado = null;
    empleado = empleadoS.findByTipoVacuna(tipo);
    Map<String, Object> mensaje = new HashMap<>();
    if (empleado.size() == 0) {
      mensaje.put("Mensaje", "No existen Datos para la busqueda realizada");
      return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<List<EmpleadoE>>(empleado, HttpStatus.OK);
  }

  @GetMapping("/fechaVacunacion")
  public ResponseEntity<?> getFechaVacunacion(Date  desdef , Date hastaf ) {
    List<EmpleadoE> empleado = null;
    empleado = empleadoS.findByFechaVacunacion(desdef , hastaf) ;
    Map<String, Object> mensaje = new HashMap<>();
    if (empleado.size() == 0) {
      mensaje.put("Mensaje", "No existen Datos para la busqueda realizada");
      return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<List<EmpleadoE>>(empleado, HttpStatus.OK);
  }




}
