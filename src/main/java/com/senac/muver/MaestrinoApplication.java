package com.senac.muver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaestrinoApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/maestrino-0.0.1-SNAPSHOT");
		SpringApplication.run(MaestrinoApplication.class, args);
	}

}
