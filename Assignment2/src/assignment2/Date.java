package assignment2;
import java.io.*;
import java.util.*;
public class Date {
    int y , m , d , sy , sd , sm;
    Calendar ca1 = Calendar.getInstance();
    void getdata()throws IOException
    {
         BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
         System.out.println("Enter Your Birthdate : ");
         System.out.print("Date : ");
         d=Integer.parseInt(bf.readLine());
         System.out.print("Month : ");
         m=Integer.parseInt(bf.readLine());
         System.out.print("Year : ");
         y=Integer.parseInt(bf.readLine());
         sm=ca1.get(Calendar.MONTH)+1;
         sy=ca1.get(Calendar.YEAR);
         sd=ca1.get(Calendar.DATE);
    }
    void calculate()
    {
        ca1.set(sy,sm,sd);
	ca1.add(Calendar.YEAR,-y);
	ca1.add(Calendar.MONTH,-m);
	ca1.add(Calendar.DATE,-d);
    }
    void putdata()
    {
        System.out.println("Your Birthdate : "+d+"/"+m+"/"+y);
        System.out.println("Today's Date   : "+sd+"/"+sm+"/"+sy);
	System.out.println("You Are : "+ca1.get(Calendar.YEAR)+" Years "+ca1.get(Calendar.MONTH)+" Months And "+ca1.get(Calendar.DATE)+" Days OLD");
    }
    public static void main(String[] args)throws IOException {
        Date d = new Date();
        d.getdata();
        d.calculate();
        d.putdata();
        
    }
}
