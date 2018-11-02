package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {

	public static void main(String[] args) {
		ApplicationContext ctx 
		= new AnnotationConfigApplicationContext(AppConfig.class);
		HrService service = (HrService) ctx.getBean("hrService");
		System.out.println(service.registerEmployee(100, "John", "Bangalore", 43000));

	}

}
