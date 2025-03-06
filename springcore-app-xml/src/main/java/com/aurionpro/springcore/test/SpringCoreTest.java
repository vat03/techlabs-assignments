package com.aurionpro.springcore.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aurionpro.springcore.model.Computer;
import com.aurionpro.springcore.model.Harddisk;

public class SpringCoreTest {
	public static void main(String[] args) {
//		Harddisk harddisk = new Harddisk(512);
//		
//		Computer computer = new Computer("apple",harddisk);
//		
//		System.out.println(computer);

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

//		Harddisk disk = context.getBean(Harddisk.class);
//		System.out.println(disk);

		Computer computer = context.getBean(Computer.class);
		System.out.println(computer);
	}

}