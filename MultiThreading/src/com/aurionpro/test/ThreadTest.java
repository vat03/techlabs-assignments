package com.aurionpro.test;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {
	public static void main(String[] args) {
		Random random = new Random();

		Runnable myTask = () -> System.out.println("Inside myTask with runnable interface");

		Callable<Integer> callableTask = () -> random.nextInt();

		ExecutorService service = Executors.newSingleThreadExecutor();

		service.execute(myTask);

		Future<Integer> result = service.submit(callableTask);

		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("End of main !!");

		service.shutdown();
	}
}
