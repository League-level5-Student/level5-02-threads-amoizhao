package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {

	ConcurrentLinkedQueue<Task> tq;
	
	Worker(ConcurrentLinkedQueue<Task> tq) {
		this.tq = tq;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(!(tq.isEmpty())) {
			tq.remove().perform();
		}
	}


}
