package com.senac.muver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MaestrinoApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/maestrino-0.0.1-SNAPSHOT");
		SpringApplication.run(MaestrinoApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

}
