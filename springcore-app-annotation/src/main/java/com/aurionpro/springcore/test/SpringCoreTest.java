package com.aurionpro.springcore.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.aurionpro.springcore.model.Computer;
import com.aurionpro.springcore.model.Config;


public class SpringCoreTest {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		Computer computer = context.getBean(Computer.class);
		System.out.println(computer);
	}

}