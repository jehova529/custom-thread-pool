package com.example.threadpool;

import java.util.concurrent.BlockingQueue;

/**
 * The Class WorkerThread.
 */
public class WorkerThread extends Thread {

	/** The queue. */
	private BlockingQueue<Runnable> queue;

	/**
	 * Instantiates a new worker thread.
	 *
	 * @param name  the name
	 * @param queue the queue
	 */
	public WorkerThread(String name, BlockingQueue<Runnable> queue) {
		super(name);
		this.queue = queue;
	}

	/**
	 * Run.
	 */
	@Override
	public void run() {
		while (true) {
			try {
				queue.take().run();
			} catch (InterruptedException ex) {
				System.out.println("Exception occured while waiting for the task from queue: " + ex);
			} catch (RuntimeException ex) {
				System.out.println("Exception occured while executing the task: " + ex);
			}
		}
	}
}
