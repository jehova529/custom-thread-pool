package com.example.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The Class CustomThreadPoolExecutor.
 */
public class CustomThreadPoolExecutor implements CustomThreadPool {

	/** The threads. */
	private WorkerThread[] threads;

	/** The queue. */
	private BlockingQueue<Runnable> queue;

	/**
	 * Instantiates a new custom thread pool executor.
	 *
	 * @param poolSize the pool size
	 */
	public CustomThreadPoolExecutor(int poolSize) {
		threads = new WorkerThread[poolSize];
		queue = new LinkedBlockingQueue<>();
		for (int i = 0; i < poolSize; i++) {
			threads[i] = new WorkerThread("CustomThread-" + (i + 1), queue);
			threads[i].start();
		}
	}

	/**
	 * Submit.
	 *
	 * @param task the task
	 */
	@Override
	public void submit(Runnable task) {
		try {
			queue.put(task);
		} catch (InterruptedException e) {
			System.out.println("Exception occured while adding the task in the queue");
		}
	}

}
