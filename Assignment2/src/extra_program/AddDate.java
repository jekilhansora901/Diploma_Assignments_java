package assignment2;
import java.util.Calendar;
import java.io.*;
public class AddDate
{
public static void main(String[] args)throws IOException
{
    BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
	Calendar ca1 = Calendar.getInstance();
        int y , m , d , sy , sd , sm;
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
        System.out.println("Your Birthdate : "+d+"/"+m+"/"+y);
        System.out.println("Today's Date   : "+sd+"/"+sm+"/"+sy);
        ca1.set(sy,sm,sd);
	ca1.add(Calendar.YEAR,-y);
	ca1.add(Calendar.MONTH,-m);
	ca1.add(Calendar.DATE,-d);
	System.out.println("You Are : "+ca1.get(Calendar.YEAR)+" Years "+ca1.get(Calendar.MONTH)+" Months And "+ca1.get(Calendar.DATE)+" Days OLD");
}
}
