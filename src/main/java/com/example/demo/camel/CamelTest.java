package com.example.demo.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class CamelTest extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("file:/home/carlos/Escritorio/directorio_in")
		.autoStartup(true)
		.log(">>>> Movemos el archivo al directorio de salida")
		.to("file:/home/carlos/Escritorio/directorio_out")
		.end();
		
	}

}
