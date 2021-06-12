class matri extends Thread
{
	int a,b,ad;
	matri (int d,int c)
	{
		a=d;
		b=c;
		start();
	}
	synchronized public void run()
	{
		ad=a+b;
	}
}
class matrix
{
	public static void main(String ss[])
	{
		int m,n;
		m=2;
		n=2;
		int d;
		d=m*n;
		matri s[]=new matri[d];
		int A[][]=new int[m][n];
		int B[][]=new int[m][n];
		int C[][]=new int[m][n];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				A[i][j]=i;
				B[i][j]=j;
			}
		}
		System.out.println("Matrix A : ");
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(A[i][j]);
			}
			System.out.println("");
		}
		System.out.println("Matrix B : ");
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(B[i][j]);
			}
			System.out.println("");
		}
		int e=0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				try
				{
				s[e]=new matri(A[i][j],B[i][j]);
				s[e].join();
				C[i][j]=s[e].ad;
		//		System.out.println("C["+i+"]["+j+"]="+C[i][j]);
				e++;
				}
				catch(InterruptedException es)
				{}
			}
		}
		
		e=0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				C[i][j]=s[e].ad;
				e++;
			}
		}
		System.out.println("Matrix C : ");
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(C[i][j]);
			}
			System.out.println("");
		}
	}
}

	
	