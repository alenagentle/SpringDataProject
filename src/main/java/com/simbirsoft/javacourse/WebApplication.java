package com.simbirsoft.javacourse;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {


	public static void main(String[] args) {
		System.out.println("Hello world!");
		SpringApplication.run(WebApplication.class, args);
		//ApplicationContext context = SpringApplication.run(WebApplication.class, args);

//		EmployeeData data = context.getBean(EmployeeData.class);
//
//		Тут должен быть код добавления пользователей в EmployeeData
	}
}
