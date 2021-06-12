package assignment2;
import java.io.*;
public class recursionf 
{
    static int fact(int a)
    {
        int n;
        if(a==1)
        {
            return 1;
        }
        else
        {
            n = fact(a-1)*a;
            return n;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        int f,no;
        System.out.print("Enter A Number : ");
        no = Integer.parseInt(bf.readLine());
        f = fact(no);
        System.out.println("Factorial Of "+no+" : "+f);
    }
}