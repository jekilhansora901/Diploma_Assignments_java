import java.util.*;
class aray
{
	public static void main(String []s)
	{
		int a[]=new int[5];
		int p,n,i,ch;
		for(i=0;i<5;i++)
		{
			a[i]=-1;
		}
		Scanner ss=new Scanner(System.in);
		do
		{
		System.out.println("Enter Pos : ");
		p=ss.nextInt();
		System.out.println("Enter Data : ");
		n=ss.nextInt();
		try
		{
			if(p>5) throw new ArrayIndexOutOfBoundsException();
			if(n<0) throw new NumberFormatException();
			if(a[p]!=-1) throw new InterruptedException();
			a[p]=n;
			System.out.println("Data Insrted..");
					
		}
		catch(ArrayIndexOutOfBoundsException j)
		{
			System.out.println("Array Index Out of Bound ..");
		}
		catch(InterruptedException k)
		{
			System.out.println("Position is already occupied ..");
		}
		catch(NumberFormatException l)
		{
			System.out.println("Negative No is not Allowed ..");
		}
		System.out.println("Do you want to continue ?(1/0) : ");
		ch=ss.nextInt();
		}while(ch==1);
	}
}