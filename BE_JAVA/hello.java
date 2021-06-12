class hell extends Thread
{
	int id;
	hell(int d)
	{
		id=d;
		start();
	}
	synchronized public void run()
	{
		for(int i=0;i<10;i++)
		{
			try
			{
			System.out.println("Hello"+id);
			Thread.sleep(300);
			}
			catch(InterruptedException iew)
			{
			}
		}
	}
}
class hello
{
	public static void main(String s[])
	{
		hell h=new hell(1);
		hell h1=new hell(2);
		hell h2=new hell(3);
		try
		{
		h1.join();
		h.join();
		h2.join();
		}
		catch(InterruptedException i)
		{}
		
		System.out.println("Good Bye..");
	}
}
	