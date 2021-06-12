import java.util.*;
class longest_subset
{
	static void lcs(String x,int m,String y,int n)
	{
		int c[][]=new int[m+1][n+1];
		int i,j;
		int b[][]=new int[m+1][n+1];
		for(i=1;i<=m;i++)
			c[i][0]=0;
		for(j=0;j<=n;j++)
			c[0][j]=0;
		for(i=1;i<=m;i++)
		{
			for(j=1;j<=n;j++)
			{
				if(x.charAt(i+1)==y.charAt(j+1))
				{
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]=100;
				}
				else if(c[i-1][j]>=c[i][j-1])
				{
					c[i][j]=c[i-1][j];
					b[i][j]=200;
				}
				else
				{
					c[i][j]=c[i][j-1];
					b[i][j]=300;
				}
			}
		}
		System.out.println("LCS is : "+c[m][n]);
	}
	public static void main(String s[])
	{
		String x,y;
		int m,n;
		Scanner ss=new Scanner(System.in);
		System.out.println("Enter String 1 : ");
		x=ss.next();
		System.out.println("Enter String 2 : ");
		y=ss.next();
		m=x.length();
		n=y.length();
		System.out.println("Length : "+m+n);
		lcs(x,m,y,n);
	}
}