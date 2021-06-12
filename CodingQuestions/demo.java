import java.util.*;
public class demo
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		double a,d,tmp,x,y;
		
			a=sc.nextInt();
			d=sc.nextInt();
			d=d*d;
			tmp=Math.sqrt(d/3);
			x=tmp*tmp;
			y=a-tmp;
			System.out.println(x+" "+y);
					
	}
	
	
}