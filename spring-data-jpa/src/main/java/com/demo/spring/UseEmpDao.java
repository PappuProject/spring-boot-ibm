package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseEmpDao {

	public static void main(String[] args) {
	
		ApplicationContext ctx= new AnnotationConfigApplicationContext(JpaConfig.class);

		HrService service=ctx.getBean(HrService.class);
		
		System.out.println(service.registerEmp(203, "Teja", "Hyderabad", 67000));
		
		for(String s:service.listAllEmps()) {
			
			System.out.println(s);
		}
	}

}
