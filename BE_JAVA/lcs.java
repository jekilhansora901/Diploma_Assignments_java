import java.util.*;
class lcs {
    static void findlcs(String x,String y)
	{
		int i,j;
		int n = x.length();
        int m = y.length();
        int[][] C = new int[n+1][m+1];
        int[][] B = new int[n+1][m+1];
	    for (i = 0; i <= n; i++) 
		{
            C[i][0] = 0;
        }
	
        for (j = 0; j <= m; j++) 
		{
            C[0][j] = 0;
        }
        for (i = 1; i <= n; i++) 
		{
            for (j = 1; j <= m; j++) 
			{
                if (x.charAt(i-1) == y.charAt(j-1)) 
				{
                    C[i][j]=C[i-1][j-1]+1;
                    B[i][j]=1;  
                }
                else if (C[i-1][j]>=C[i][j-1]) {
                    C[i][j]=C[i-1][j];
                    B[i][j] = 2;
                }
                else {
                    C[i][j]=C[i][j-1];     
                    B[i][j]=3; 
                }
            }
        }
        
        String lcs1 = new String();
        i=n;
        j=m;
        while (i!=0 && j!=0)
		{
            switch(B[i][j])
			{
				case 1: lcs1=x.charAt(i-1) + lcs1;
						i--;
						j--;
						break;
				case 2: i--;
						break;
				case 3: j--;
						break;
            }
        }
		 System.out.println("String X is " + x);
        System.out.println("String Y is " + y);
        System.out.println("The length of LCS is " + C[n][m]);
        System.out.println("The LCS is " + lcs1);
        
	}
    public static void main(String[] args) {
        int i,j;
		Scanner s=new Scanner(System.in);
        String X;
        String Y;
		System.out.println("Enter String 1 : ");
		X=s.next();
		System.out.println("Enter String 2 : ");
		Y=s.next();
		findlcs(X,Y);/*
        int n = X.length();
        int m = Y.length();
        int[][] C = new int[n+1][m+1];
        int[][] B = new int[n+1][m+1];
	    for (i = 0; i <= n; i++) 
		{
            C[i][0] = 0;
        }
	
        for (j = 0; j <= m; j++) 
		{
            C[0][j] = 0;
        }
        for (i = 1; i <= n; i++) 
		{
            for (j = 1; j <= m; j++) 
			{
                if (X.charAt(i-1) == Y.charAt(j-1)) 
				{
                    C[i][j]=C[i-1][j-1]+1;
                    B[i][j]=1;  
                }
                else if (C[i-1][j]>=C[i][j-1]) {
                    C[i][j]=C[i-1][j];
                    B[i][j] = 2;
                }
                else {
                    C[i][j]=C[i][j-1];     
                    B[i][j]=3; 
                }
            }
        }
        
        String lcs1 = new String();
        i=n;
        j=m;
        while (i!=0 && j!=0)
		{
            switch(B[i][j])
			{
				case 1: lcs1=X.charAt(i-1) + lcs1;
						i--;
						j--;
						break;
				case 2: i--;
						break;
				case 3: j--;
						break;
            }
        }
        System.out.println("String X is " + X);
        System.out.println("String Y is " + Y);
        System.out.println("The length of LCS is " + C[n][m]);
        System.out.println("The LCS is " + lcs1);
        */
    }
}