package com.aurionpro.violation.test;

import com.aurionpro.violation.model.IWorker;
import com.aurionpro.violation.model.Labour;
import com.aurionpro.violation.model.Robot;

public class IWorkerTest {
	public static void main(String[] args) {
		
		IWorker labour = new Labour();
		IWorker robot = new Robot();
		
		System.out.println("Labour: ");
		labour.startWork();
		labour.stopWork();
		labour.eat();
		labour.drink();
		
		System.out.println();
		
		System.out.println("Robot: ");
		robot.startWork();
		robot.stopWork();
	}
}
