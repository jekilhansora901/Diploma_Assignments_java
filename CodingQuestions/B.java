import static java.lang.Math.round;
import java.util.Scanner;
public class B {
    public static void main(String[] args) {
        double M, T, R, S, Temp;
        Scanner sc = new Scanner(System.in);
        M = Double.parseDouble(sc.next());
        try
        {
        if(M>0)
        {
            T = Double.parseDouble(sc.next());
            if(T>0)
            {
            R = Double.parseDouble(sc.next());
                if(R>=0)
                {
                    Temp = M * T;
                    double tr;
                    tr = R/12;
                    S=0;
                    for(int i=0;i<T;i++)
                    {
                        Temp = (Temp - ((Temp * tr)/100))-M;
                    }
                    S = (M * T) + Temp;
                    S = round(S);
                    Integer d;
                    d = (int) S;
                    System.out.println(d);
                }
            }
        }
        }
        catch(Exception e)
        {
        }
        }
    }
