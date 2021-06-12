package assignments;
import java.io.*;
public class function {
     public static double fact(int a)
    {
        int i;
        double f=1;
        for(i=1;i<=a;i++)
        {
                f=f*i;
        }
        return f;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int n,i,x;
        double d,ans=0;
        System.out.println("Enter the value of N : ");  
        n=Integer.parseInt(f.readLine());
        System.out.println("Enter the value of X : ");  
        x=Integer.parseInt(f.readLine());
        for(i=0;i<=n;i++)
        {
            d=fact(i);
            ans = ans + ((x^i)/d);
        }
        System.out.println("Answer OF Series Is : "+ans);
    }
}