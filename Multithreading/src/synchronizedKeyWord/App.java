package synchronizedKeyWord;

public class App {
	int count = 0;
	public static void main(String[] args) throws InterruptedException {
		App app = new App();
		app.doWork();

	}
	public synchronized void increment()
	{
		count++;
	}
	public void doWork() throws InterruptedException
	{
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run()
			{
				for(int i = 0; i < 1000; i++)
					increment();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run()
			{
				for(int i = 0; i < 1000; i++)
					increment();
			}
		});
		t1.start();
		t2.start();
		//t1.join();
		//t2.join();
		System.out.println(count);
	}

}
