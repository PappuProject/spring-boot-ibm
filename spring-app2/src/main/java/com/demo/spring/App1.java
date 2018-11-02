package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		HrService service = (HrService) ctx.getBean("hr");
		System.out.println(service.registerEmployee(100, "John", "Bangalore", 43000));

	}

}
