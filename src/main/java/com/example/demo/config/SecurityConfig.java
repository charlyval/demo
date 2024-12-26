package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		return httpSecurity
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/saludo/hola1").permitAll();  //endpoint sin securizar
                    auth.anyRequest().authenticated(); //Todos los demás necesitan autorización
                })
                .formLogin(login -> {  
                	login.permitAll(); /// Permite a todos los endpoints autenticarse mediante formulario.
                	login.successHandler(authenticationSuccessHandler()); //Si la autenticación mediante el formulario es exitosa, se realizan las acciones del handler
                })
                .sessionManagement(sessionManagement -> sessionManagement  
                	.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)  //Al autenticarse el usuario, se crea siempre una sesión.
                	.invalidSessionUrl("/login") 
                	.maximumSessions(1)
                	.sessionRegistry(sessionRegistry())
                	
                )
                .httpBasic(Customizer.withDefaults()) //Desde Postman añadir Basic Auth (usuario y contraseña)
                .build();
	}
	
	@Bean
	SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
	
	
	@Bean
	AuthenticationSuccessHandler authenticationSuccessHandler() {
		return ((request, response, authentication) -> {
			response.sendRedirect("saludo/session");
		});
		
	}
	

}
