package com.projeto.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.projeto.loja")
public class LojaApplication {

	public static void main(String[] args) {

		SpringApplication.run(LojaApplication.class, args);
	}

}
