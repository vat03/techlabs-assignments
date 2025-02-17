package com.aurionpro.solution.test;

import com.aurionpro.solution.model.IHumanWorker;
import com.aurionpro.solution.model.Labour;
import com.aurionpro.solution.model.Robot;
import com.aurionpro.solution.model.IWorker;

public class WorkerTest {

	public static void main(String[] args) {

		IHumanWorker labour = new Labour();
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
