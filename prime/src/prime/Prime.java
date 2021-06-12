package prime;
import java.io.*;
public class Prime {
    public static void main(String args[]) {
        int i,j,s=0,d=0;
        for(i=1;i<=100;i++)
        {
            s=0;
            for(j=1;j<=i;j++)
            {
                if(i%j==0)
                {
                    s=s+1;
                }
            }
            if(s==2)
            {
                System.out.println(i);
                d = d + 1 ;
            }
            
        }
        System.out.println("The no of prime are : "+d);
    }
}
