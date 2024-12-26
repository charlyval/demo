package com.example.demo.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class DemoController {
	
	@Autowired
	private SessionRegistry sessionRegistry; 
	
	@GetMapping("/hola1")
	public String hola1(){
		//Prueba Jenkins, sexta parte
		String saludo = "Saludo sin securizar";
		return saludo;
	}
	
	@GetMapping("/hola2")
	public String hola2(){
		//Prueba Jenkins, sexta parte
		String saludo = "Saludo securizado";
		return saludo;
	}
	
	@GetMapping("/session")
	ResponseEntity<?> getDetailsSession() {
		
		String sessionId = "";
		User userObject = null;
		
		List<Object> sessions = sessionRegistry.getAllPrincipals();
		for(Object session : sessions) {
			if(session instanceof User) {
				userObject = (User) session; 
			}
			List<SessionInformation> sessionInformations = sessionRegistry.getAllSessions(session, false);
			
			for(SessionInformation sessionInformation : sessionInformations) {
				sessionId = sessionInformation.getSessionId();
			}
		}
		
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("response", "Hello World");
		responseMap.put("sessionId", sessionId);
		responseMap.put("userObject", userObject);
		
		
		return ResponseEntity.ok(responseMap);
	}

}
