import java.util.*;
class prime extends Thread
{
	int n,d,i,j,nn;
	static int no=0;
	synchronized void prim(int de,int dd)
	{
		n=de;
		nn=dd;
		Thread.currentThread().setPriority(1);
		start();
		

	}
	
	synchronized public void run()
	{	
		System.out.println(" start Thread id : ");
		for(i=n;i<nn;i++)
		{
			d=0;
			for(j=1;j<=i;j++)
			{
				if(i%j==0)
					d++;
			}
			if(d==2)
			{
				System.out.print(" "+i);
			}
		}
		System.out.println(" end Thread id : ");
		}
}
class pmain
{
	public static void main(String ss[])
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter No of Element : ");
		int a;
		a=s.nextInt();
		int d,aa,sa;
		d=a/100;
		aa=0;
		sa=aa+100;
		for(int i=0;i<=d;i++)
		{
			prime p=new prime();
			if(i==d)	sa=a;

			p.prim(aa,sa);
			aa=aa+100;
			sa=sa+100;
			try
			{
			Thread.sleep(100);
			}
			catch(InterruptedException e)
			{}
		}
	}
}