package com.example.threadpool;

/**
 * The Interface CustomThreadPool.
 */
public interface CustomThreadPool {
	
	/**
	 * Submit.
	 *
	 * @param task the task
	 */
	public void submit(Runnable task);
}
