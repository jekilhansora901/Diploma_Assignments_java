import java.util.*;
class quick
{
	static void quick_sort(int a[],int start, int end)
	{
		int i,j,temp,key,flag=1;
		if(start<end)
		{
			i=start;
			j=end+1;
			key=a[start];
			while(flag==1)
			{
				i++;
				while(a[i]<key)
					i++;
				j--;
				while(a[j]>key)
					j--;
				if(i<j)
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
				else
					flag=0;
			}
			temp=a[start];
			a[start]=a[j];
			a[j]=temp;
			quick_sort(a,start,j-1);
			quick_sort(a,j+1,end);
		}
	}	
	public static void main(String [] ss)
	{
		
		int s,e,i,n;
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enter No of Element : ");
		//n=sc.nextInt();
		n=Integer.parseInt(ss[0]);
		int a[] = new int[n];
		System.out.println("Enter Elements : ");
		for(i=0;i<n;i++)
		{
			a[i]=(int) (Math.random()*n);
		}
		System.out.println("Array : ");
		for(i=0;i<n;i++)
		{
			System.out.println(" "+a[i]);
		}
		quick_sort(a,0,n-1);
		System.out.println("Sorted Array : ");
		for(i=0;i<n;i++)
		{
			System.out.println(" "+a[i]);
		}
	}
}