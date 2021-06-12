import java.util.*;
class car
{
	int model_no;
	String name,color;
	void getCarDetail()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Car Model No : ");
		model_no=s.nextInt();
		System.out.println("Enter Car Name : ");
		name=s.next();
		System.out.println("Enter Car Color : ");
		color=s.next();
	}
	void showCarDetail()
	{
		System.out.println("Car Model No. : "+model_no);
		System.out.println("Car Name :"+name);
		System.out.println("Car Color :"+color);
	}
	public static void main(String sd[])
	{
		car c[]=new car[3];
		for(int i=0;i<3;i++)
		{
			c[i]=new car();
			c[i].getCarDetail();
		}
		for(int i=0;i<3;i++)
		{
			c[i].showCarDetail();
		}
	}
}
		