package br.com.sptech.projetoclienteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients // esta anotação libera o uso do OpenFeign no projeto
@SpringBootApplication
public class ProjetoClienteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoClienteApiApplication.class, args);
	}

}
