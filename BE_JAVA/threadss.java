import java.lang.*;
class mythread extends Thread
{
	String msg;
	mythread(String dm,String name)
	{
		super(name);
		msg=dm;
		start();
	}
	public void run()
	{
		try
		{
			int i;
			for(i=0;i<3;i++)
			{
				System.out.println("Hello : "+i+" "+msg);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException ie)
		{
			System.out.println("Exception Caught");
		}
	}
}
class threadss
{
	public static void main(String args[])
	{
		mythread th0=new mythread("You Are Welcome to Thread 1 ","Grand");
		mythread th1=new mythread("You Are Welcome to Thread 2 ","Father");
		mythread th2=new mythread("You Are Welcome to Thread 3 ","Son");
	}
}