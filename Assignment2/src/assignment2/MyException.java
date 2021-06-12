package assignment2;
import java.io.*;
public class MyException {
    public static void main(String[] args)throws IOException {
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            Throwable t =new Throwable("Not Elligible...");
            int age;
            System.out.print("Enter Your Age : ");
            age =  Integer.parseInt(bf.readLine());
            if(age <=18) throw t;
            {
                System.out.println("Please Give Your Vote ....");
            }
        }
        catch(Throwable e)
        {
                System.out.println("Sorry :- "+e.getMessage());
        }
        }
    }

