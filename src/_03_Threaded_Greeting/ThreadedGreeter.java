package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {

	int var;

	ThreadedGreeter(int var) {
		this.var = var;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from thread number: " + var);
		if (var <= 50) {
			Thread t = new Thread(new ThreadedGreeter(var + 1));
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
