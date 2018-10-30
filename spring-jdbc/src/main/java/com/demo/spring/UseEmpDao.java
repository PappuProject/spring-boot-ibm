package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseEmpDao {

	public static void main(String[] args) {
	
		ApplicationContext ctx= new AnnotationConfigApplicationContext(JdbcConfig.class);

		HrService service=ctx.getBean(HrService.class);
		System.out.println(service.registerEmp(201, "Ramesh", "Chennai", 37000));
		
		for(String s:service.listAllEmps()) {
			System.out.println(s);
		}
	}

}
