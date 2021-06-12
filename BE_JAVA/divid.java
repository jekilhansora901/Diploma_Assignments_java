import java.util.*;
class divid
{
	int a,b,c;
	divid()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter No 1 : ");
		a=s.nextInt();
		System.out.println("Enter No 2 : ");
		b=s.nextInt();
		c=0;
	}
	void calc()
	{
		try
		{
			c=a/b;
			System.out.println("Division : "+c);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Error: Divide By Zero...");
		}
	}
	public static void main(String a[])
	{
		divid d=new divid();
		d.calc();
	}
}