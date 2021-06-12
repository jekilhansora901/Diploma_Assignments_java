package assignments;
import java.io.*;
public class reverse {
    public static void main(String[] args)throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int a,r=0,temp,c;
        System.out.println("Enter the Number : ");
        a=Integer.parseInt(f.readLine());
        c=a;
        while (a>0)
        {
                temp=a%10;
                r=r*10+temp;
                a=a/10;
        }
        System.out.println("Given Value is : "+c);
        System.out.println("Reverse Order Value : "+r);
    }
}
