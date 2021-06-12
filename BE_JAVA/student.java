import java.util.*;
class student
{
	int rollno;
	String name;
	int marks[]=new int[5];
	void getinfo()
	{
			Scanner s=new Scanner(System.in);
			System.out.println("Enter Roll Number : ");
			rollno=s.nextInt();
			System.out.println("Enter Name : ");
			name=s.next();
			System.out.println("Enter Marks of ");
			for(int i=0;i<5;i++)
			{
				System.out.print("Subject "+(i+1)+" : ");
				marks[i]=s.nextInt();
			}
	}
	float calcpi()
	{
		try
		{
			for(int i=0;i<5;i++)
			{
				if(marks[i]<35) throw new InterruptedException();
			}
			float cpi;
			int sum=0;
			for(int i=0;i<5;i++)
				sum=sum+marks[i];
			cpi=sum/50;
			return cpi;
		}
		catch(InterruptedException ie)
		{
			System.out.println("You Are Falied..");
			return 0;
		}
	}
	void display()
	{
		System.out.println("Rollno :"+rollno);
		System.out.println("Name   :"+name);
		float cpi=calcpi();
		if(cpi!=0)
		System.out.println("CPI    :"+cpi);
	}
	public static void main(String d[])
	{
		student st=new student();
		st.getinfo();
		st.display();
	}
}