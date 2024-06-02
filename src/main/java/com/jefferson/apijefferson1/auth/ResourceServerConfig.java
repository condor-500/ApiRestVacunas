package com.jefferson.apijefferson1.auth;



import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;



@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
    
         http.authorizeRequests()
             .antMatchers( "/swagger-ui/**","/swagger-resources/**",
             "/swagger-ui.html",
             "/index.html",
             "/v2/api-docs",
             "/webjars/**"  ).permitAll()
             .antMatchers(HttpMethod.GET, "/api/empleados/{id}").hasAnyRole("ADMIN","USER")
             .antMatchers(HttpMethod.POST, "/api/empleados").hasAnyRole("ADMIN")
             .antMatchers(HttpMethod.PUT, "/api/empleados/{id}").hasAnyRole("ADMIN")
             .antMatchers(HttpMethod.DELETE, "/api/empleados/{id}").hasAnyRole("ADMIN")
             .antMatchers(HttpMethod.GET, "/api/estadoVacuna").hasAnyRole("ADMIN")
             .antMatchers(HttpMethod.GET, "/api/fechaVacunacion").hasAnyRole("ADMIN")
             .anyRequest()
             .authenticated()
             .and()
             .httpBasic() ;
    }
    




    
}
