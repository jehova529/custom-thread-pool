package com.example.main;

import com.example.threadpool.CustomThreadPool;
import com.example.threadpool.CustomThreadPoolExecutor;

public class TaskExecutor {
	static int i = 0;

	public static void main(String[] args) {
		CustomThreadPool threadPoolExecutorService = new CustomThreadPoolExecutor(3);
		for (int i = 0; i < 5; i++) {
			final int n = i+1;
			threadPoolExecutorService.submit(
					() -> System.out.println("Task-" + n + " running in Thread-" + Thread.currentThread().getName()));
		}
	}
}
