package com.jefferson.apijefferson1.implService;



import java.util.List;
import java.util.stream.Collectors;

import com.jefferson.apijefferson1.dto.IUsuarioDTO;
import com.jefferson.apijefferson1.entity.UsuarioE;
import com.jefferson.apijefferson1.services.IUsuarioS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioImplS  implements UserDetailsService , IUsuarioS  {

    private Logger logger = LoggerFactory.getLogger(UsuarioImplS.class);

    @Autowired
    IUsuarioDTO usuarioDTO;


    @Override
    @Transactional(readOnly=true )
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       logger.info(username);
        UsuarioE usuario = usuarioDTO.findByUsuarioNombre1(username);
                
        if(usuario == null){
            logger.info(usuario.getContrasenia());
            logger.error("Error en el logeo no existe ");
            throw new UsernameNotFoundException("erro al cargar el usuario");
        }        
        List<GrantedAuthority> authorities = usuario.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.getNombre() ) )
                    .peek(authority -> logger.info("role", authority.getAuthority()))
                    .collect(Collectors.toList());
        return new User(usuario.getNombre() , usuario.getContrasenia() , true, true , true, true , authorities) ;
    }


    @Override
    public void delete(Long id) {
        usuarioDTO.deleteById(id); ;
        
    }


    @Override
    public List<UsuarioE> findAll() {
        
        return (List<UsuarioE>) usuarioDTO.findAll();
    }


    @Override
    public UsuarioE findById(Long id) {
      
        return usuarioDTO.findById(id).orElse(null);
    }


    @Override
    public UsuarioE save(UsuarioE usuario) {
        
        return usuarioDTO.save(usuario);
    }


    






    
}
