import java.text.DecimalFormat;
import java.util.Scanner;

public class bavaji {
    static double RoundTo2Decimals(double val) {
            DecimalFormat df2 = new DecimalFormat("#########.###########");
        return Double.valueOf(df2.format(val));
}
    public static void main(String[] args) {
        try
        {
        
        Scanner sc = new Scanner(System.in);
        double a, d,x, y;
        a = sc.nextDouble();
        d = sc.nextDouble();
        if((a > 0  && a <=(57 * d)) && (d > 0  && d <=(1.7 * a)))
        {    
                d = d * d;
                x = 2 * Math.sqrt(d / 3);
                y = a - Math.sqrt(d / 3);
                System.out.println("X= "+RoundTo2Decimals(y));
                System.out.println("Y= "+RoundTo2Decimals(x));
        }
        else
        {
            System.out.println("Invalid Input");
        }
        }
        catch(Exception e)
        {
            System.out.println("Invalid Input");
        }
    }
}
