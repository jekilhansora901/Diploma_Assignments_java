import java.util.*;
import java.lang.*;
class calcc
{
	public static  void main(String sd[])
	{
		int a,b,ans=0,ch;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Data : ");
		a=s.nextInt();
		System.out.println("Enter Data : ");
		b=s.nextInt();
		System.out.println("1. Add");
		System.out.println("2. Add");
		System.out.println("3. Add");
		System.out.println("4. Add");
		System.out.println("Enter Your Choice : ");
		ch=s.nextInt();
		switch(ch)
		{
			case 1:ans=a+b;
					break;
			case 2:ans=a-b;
					break;
			case 3:ans=a*b;
					break;
			case 4:ans=a/b;
					break;
		}
		System.out.println("Answer : "+ans);
	}
}