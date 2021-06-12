import java.util.*;
public class selection
{
	public static void main(String args[])
	{
		int n=Integer.parseInt(args[0]);
		int a[]=new int[n];
		long start,end,total;
		int i,j,tmp,key;
		for(i=0;i<n;i++)
		{
			a[i]=(int) (Math.random()*1000);
		}
		start=System.currentTimeMillis();
		for(i=0;i<a.length-1;i++)
		{
			key=i;
				for(j=i+1;j<a.length;j++)
				{
					if(a[j]<a[key])
					{
						key=j;
					}
				}
				if(key != i)
				{
						tmp=a[i];
						a[i]=a[key];
						a[key]=tmp;
				}
		}
		end=System.currentTimeMillis();
		total=end-start;
		System.out.println("The Sorted List Is: ");
		for(i=0;i<a.length;i++)
		{
		System.out.println(a[i]);
		}
		System.out.println("Required Time Is: "+total);

	}
}