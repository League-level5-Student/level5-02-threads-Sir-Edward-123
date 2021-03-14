package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {
	
	int number;
	
	ThreadedGreeter(int num){
		number = num;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from thread number: " + number);
		if(number <= 50) {
			Thread t = new Thread(new ThreadedGreeter(number + 1));
			
			t.start();
			try {
				t.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
