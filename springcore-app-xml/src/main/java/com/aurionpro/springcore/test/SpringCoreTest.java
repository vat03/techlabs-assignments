package com.aurionpro.springcore.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aurionpro.springcore.model.Computer;
import com.aurionpro.springcore.model.Harddisk;

public class SpringCoreTest {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		Computer computer = context.getBean(Computer.class);
		System.out.println(computer);
	}

}