package basicThreadSynchronization;

import java.util.Scanner;

public class App1
{
	public static void main(String[] args)
	{
		Processor p1 = new Processor();
		p1.start();
		System.out.println("Press return to pause : ");
		Scanner keyboard = new Scanner(System.in);
		keyboard.nextLine();
		p1.shutdown();
	}
}