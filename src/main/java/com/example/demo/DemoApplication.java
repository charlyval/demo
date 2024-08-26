package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/saludo")
	public String saludo(){
		//Prueba Jenkins, sexta parte
		String saludo = "Hola, que tal estamos desde la actualizazión del tag 0.0.1";
		return saludo;
	}
}
