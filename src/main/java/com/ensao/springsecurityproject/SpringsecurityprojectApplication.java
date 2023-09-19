package com.ensao.springsecurityproject;

import com.ensao.springsecurityproject.auth.RegisterRequest;
import com.ensao.springsecurityproject.auth.authService;
import com.ensao.springsecurityproject.model.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.ensao.springsecurityproject.model.Role.ADMIN;
import static com.ensao.springsecurityproject.model.Role.MANAGER;

@SpringBootApplication
public class SpringsecurityprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityprojectApplication.class, args);

	}
	/*@Bean
	public CommandLineRunner commandLineRunner(authService service){
		return args -> {
			var admin = RegisterRequest
					.builder()
					.firstName("admin")
					.lastName("admin")
					.email("admin@gmail.com")
					.password("123")
					.role(ADMIN)
					.build();
			System.out.println("ADMIN TOKEN :"+ service.register(admin).getToken());

			var manager = RegisterRequest
					.builder()
					.firstName("manager")
					.lastName("manager")
					.email("manager@gmail.com")
					.password("123")
					.role(MANAGER)
					.build();
			System.out.println("MANAGER TOKEN :"+ service.register(admin).getToken());

		};*/


}
