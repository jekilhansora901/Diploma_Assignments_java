class common
{
	int n;
	volatile int flag=0;
	synchronized void put(int i)
	{
		try
		{
			if(flag==1)
				wait();
				n=i;
				flag=1;
				System.out.println("PUt...");
				notify();
		}
		catch(InterruptedException e)
		{
			System.out.println("Wait..");
		}
	}
	synchronized void get()
	{
		try
		{
			if(flag==0)
				wait();
				System.out.println("Consume Item : "+n);
				flag=0;
				notify();
		}
		catch(InterruptedException e)
		{
			System.out.println("Wait..");
		}
	}
}
class producer extends Thread
{
	common c;
	int id;
	producer(int d_id,common d_c)
	{
		super();
		id=d_id;
		c=d_c;
		start();
	}
	public void run()
	{
		for(int i=0;i<4;i++)
		{
			try
			{
				c.put(i);
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				System.out.println("Wait..");
			}
		}
	}
}
class consumer extends Thread
{
	common c;
	int id;
	consumer(int d_id,common d_c)
	{
		super();
		id=d_id;
		c=d_c;
		start();
	}
	public void run()
	{
		for(int i=0;i<4;i++)
		{
			try
			{
				c.get();
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				System.out.println("Wait..");
			}
		}
	}
}
class pro_con
{
	public static void main(String s[])
	{
		common c=new common();
		producer p=new producer(0,c);
		consumer cm=new consumer(0,c);
		try
		{
			p.join();
			cm.join();
		}
		catch(InterruptedException e)
		{
		}
	}
}