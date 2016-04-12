package multiLocksUsingSychronizedCodeBlock;

import java.util.ArrayList;
import java.util.Random;

public class Worker 
{
	Random random = new Random();
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	private ArrayList<Integer> list1 = new ArrayList<Integer>();
	private ArrayList<Integer> list2 = new ArrayList<Integer>();
	public void stageOne()
	{
		synchronized(lock1)
		{
			try{
				Thread.sleep(1);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}
	public void stageTwo()
	{
		synchronized(lock2)
		{
			try
			{
				Thread.sleep(1);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}
	public void process()
	{
		for(int i = 0; i < 10000; i++)
		{
			stageOne();
			stageTwo();
		}
	}
	public void main() throws InterruptedException
	{
		System.out.println("Starting...");
		Thread t1 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				process();
			}
			
		});
		Thread t2 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				process();
			}
			
		});
		long start = System.currentTimeMillis();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		long end = System.currentTimeMillis();
		System.out.println("Time taken : " + (end - start));
		System.out.println("List 1 : " + list1.size() + ";");
		System.out.println("List 2 : " + list2.size() + ";");
	}
	
}
