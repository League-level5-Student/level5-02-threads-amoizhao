package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	Thread[] threads;
	ConcurrentLinkedQueue<Task> tq;

	ThreadPool(int totalThreads) {
		threads = new Thread[totalThreads];
		tq = new ConcurrentLinkedQueue<Task>();
		for(Thread thread : threads) {
			thread = new Thread(new Worker(tq));
		}
	}
	
	public void addTask(Task task) {
		tq.add(task);
	}
	
	public void start() {
		for(Thread thread : threads) {
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
