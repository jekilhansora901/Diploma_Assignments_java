import java.text.DecimalFormat;
import java.util.Scanner;

public class optimum_cost_calc {
    static double RoundTo2Decimals(double val) {
            DecimalFormat df2 = new DecimalFormat("#################.###########");
        return Double.valueOf(df2.format(val));
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, d,x, y;
        a = Double.parseDouble(sc.next());
        d = Double.parseDouble(sc.next());
        try
        {
        if(a > 0  && a <=(57 * d))
        {    
            if(d > 0  && d <=(1.7 * a))
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
        else
        {
            System.out.println("Invalid Input");
        }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
