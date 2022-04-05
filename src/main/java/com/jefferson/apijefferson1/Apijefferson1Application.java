package com.jefferson.apijefferson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Apijefferson1Application implements CommandLineRunner {


      @Autowired
	  private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Apijefferson1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
      String pass = "12345";

     for(int i = 0 ; i<=4; i++ ){
		 String  passw = passwordEncoder.encode(pass);
		 System.out.println(passw);
	 }		
	}



	
}
