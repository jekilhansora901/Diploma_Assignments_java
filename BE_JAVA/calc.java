import java.util.*;
class calc
{
	public static void main(String [] arg)
	{
		Scanner s=new Scanner(System.in);
		int no1,no2,ch,ans;
		System.out.print("Enter Number 1 : ");
		no1=s.nextInt();
		System.out.print("Enter Number 2 : ");
		no2=s.nextInt();
		System.out.println("***Basic  Calculation***");
		System.out.println("* 1.	Addition       *");
		System.out.println("* 2.	Subtraction    *");
		System.out.println("* 3.	Multiplication *");
		System.out.println("* 4.	Division       *");
		System.out.println("* 5.	Modulo         *");
		System.out.println("************************");
		System.out.print("Enter Your Choice : ");
		ch=s.nextInt();
		switch(ch)
		{
			case 1 :ans=no1+no2;
					System.out.println("Addition : "+ans);
					break;
			case 2 :ans=no1-no2;
					System.out.println("Subtraction : "+ans);
					break;
			case 3 :ans=no1*no2;
					System.out.println("Multiplication : "+ans);
					break;
			case 4 :ans=no1/no2;
					System.out.println("Division : "+ans);
					break;
			case 5 :ans=no1%no2;
					System.out.println("Modulo : "+ans);
					break;
		}
	}
}
					