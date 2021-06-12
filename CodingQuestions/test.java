import java.lang.*;
import java.util.*;

class test
{	
	public static void main(String ssdf[])
	{
		Scanner sc=new Scanner(System.in);
		int klen,i,j;
		String pt;
		System.out.println("Enter String : ");
		pt=sc.next();
		klen=pt.length();
		char nst[]=new char[klen+10];
		i=0;
		while(i<klen+10)
		{
			nst[i]='\0';
			i++;
		}
		System.out.println("String : "+pt);
		for(i=0,j=0;i<=klen/2;i=i+2)
		{
			System.out.println(pt.charAt(i));
			System.out.println(nst);
			//nst[j]=pt.charAt(i);
			if(pt.charAt(i)==pt.charAt(i+1))
			{
				nst[j]=pt.charAt(i);
				j++;
				nst[j]='x';
				j++;
				i--;
			}
			else if(i==(klen))
			{
				if(j%2==0)
				{
					nst[j]=pt.charAt(i);
					j++;
					nst[j]='x';
				}
				else
				{
					nst[j]=pt.charAt(i);
				}
			}
			else
			{
				nst[j]=pt.charAt(i);
				j++;
				nst[j]=pt.charAt(i+1);
				j++;
			}
		}
		if(klen%2==1)
		{
			nst[j]=pt.charAt(klen-1);
			j++;
			nst[j]='x';
		}
		else
		{
			nst[j]=pt.charAt(klen-1);
		}
		if(j%2==1)
		{
				j++;
				nst[j]='x';
		}
		i=0;
		System.out.println("String is : ");
		while(nst[i]!='\0')
		{
			System.out.print(nst[i]);
			i++;
		}
	}
}