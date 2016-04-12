package basicThreadSynchronization;

import java.util.Scanner;

public class Processor extends Thread
{
	private volatile boolean flag = true;//Volatile token indicates to all threads that variable tends to change, other than that uses cached variable 
	public void run()
	{
		while(flag)
		{
			System.out.println("Hello");
			try{
				
				Thread.sleep(100);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
	}
	public void shutdown()
	{
		flag = false;
	}
}
