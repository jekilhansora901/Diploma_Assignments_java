package assignments;
import java.io.*;
public class prime {

    public static void main(String[] args)throws IOException {
        BufferedReader f=new BufferedReader(new InputStreamReader(System.in));
        int i,j,s=0;
        System.out.println("Enter the Number : ");
        i=Integer.parseInt(f.readLine());
        for(j=1;j<=i;j++)
        {
        if(i%j==0)
        {
            s=s+1;
        }
        }
            if(s==2)
            {
                System.out.println(+i+" is Prime No.");
            }
            else
            {
                System.out.println(+i+" is Not Prime No.");
            }
        
}
}
