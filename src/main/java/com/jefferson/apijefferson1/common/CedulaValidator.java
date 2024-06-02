package com.jefferson.apijefferson1.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CedulaValidator implements ConstraintValidator <ValidaCedula ,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
         if( validaCedula(value)==true){
            return true ;
        }
        return false;
    }


    private boolean validaCedula(String cedula) {
        if(ValidaCodigoProvincia(cedula.substring(0, 2)) == true &&
           ValidaTercerDigito(String.valueOf(cedula.charAt(2))) == true &&
           algoritmoModulo10(cedula,Integer.parseInt(String.valueOf(cedula.charAt(9))))==true ){
            return true;
        }
        else {
            return false ;
        }
     }
     private boolean ValidaCodigoProvincia(String numero ){
         if(Integer.parseInt(numero)< 0 || Integer.parseInt(numero)>24 ){
             return false ;
         }
         else{
             return true ;
         }
     }
     private boolean ValidaTercerDigito (String numero){
        if(Integer.parseInt(numero) >= 0 || Integer.parseInt(numero)< 6){
            return true ;
        }
        else {
            return false ;
        }

     }
     private boolean algoritmoModulo10 (String digitosIniciales , int digitoVerificador){
        Integer [] arrayCoeficientes = new Integer[]{2,1,2,1,2,1,2,1,2};
        Integer [] digitosInicialesTMP = new Integer[digitosIniciales.length()];
        int indice=0;
        for(char valorPosicion: digitosIniciales.toCharArray()){
        	digitosInicialesTMP[indice] = Integer.parseInt(String.valueOf(valorPosicion));
        	indice++;
        }        
        int total = 0;
        int key = 0;
        
        for(Integer valorPosicion: digitosInicialesTMP){
        	if(key<arrayCoeficientes.length){
        		valorPosicion = (digitosInicialesTMP[key] * arrayCoeficientes[key] );
           		if (valorPosicion >= 10) 
        			{
                		char[] valorPosicionSplit = String.valueOf(valorPosicion).toCharArray();
                		valorPosicion = (Integer.parseInt(String.valueOf(valorPosicionSplit[0]))) + (Integer.parseInt(String.valueOf(valorPosicionSplit[1])));
                    }
                total = total + valorPosicion;
        	}            
            key++;
        }
        int residuo =  total % 10;
        int resultado ;
        if (residuo == 0){
            resultado = 0;        
           } 
        else {
            resultado = 10 - residuo;
           }

        if (resultado != digitoVerificador) {        	
        	
        	return false;
               }
        else {
        	return true;
        }       
         


     }

    
    
}
