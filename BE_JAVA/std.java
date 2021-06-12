import java.util.*;
class std1
{
	
	void getData(int b)
	{
		Scanner sd=new Scanner(System.in);
		String name;
			int mark[]=new int[b];
			System.out.println("Enter Name : ");
			name=sd.next();
			int sum=0,flag=1;
			for(int j=0;j<b;j++)
			{
				
				try
				{
				System.out.println("Enter Mark for Sub"+j+" : ");
				mark[j]=sd.nextInt();
				if(mark[j]<0) throw new NumberFormatException();
				sum=sum+mark[j];
				flag=1;
				}
				catch(NumberFormatException n)
				{
					System.out.println("You Entered invalied Data");
					flag=0;
				}
				if(flag==0)
					j--;
			}
		
		System.out.println("Name :"+name+" Percentage : "+((sum*100)/(b*100))+"%");
	}
}
class std
{
	public static void main(String ss[])
	{
		Scanner s=new Scanner(System.in);
		int m,n;
		m=Integer.parseInt(ss[0]);
		n=Integer.parseInt(ss[1]);
		std1 st[]=new std1[m];
		for(int i=0;i<m;i++)
		{
			st[i]=new std1();
			st[i].getData(n);
		}
	}
}