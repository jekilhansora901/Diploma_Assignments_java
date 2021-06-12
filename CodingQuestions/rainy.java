import static java.lang.Math.round;
import java.util.Scanner;
public class rainy {
    public static void main(String[] args) throws Exception {
        try
        {
            double M, tr, T, R, S, Temp;
            int i;
            Scanner sc = new Scanner(System.in);
            M = sc.nextDouble();
            if(M>0)
            {
                T = sc.nextDouble();
                if(T>0)
                {
                    R = sc.nextDouble();
                    if(R>=0)
                    {
                        Temp = M * T;
                        tr = R/12;
                        S=0;
                        for(i=0;i<T;i++)
                        {
                            Temp = (Temp - ((Temp * tr)/100))-M;
                        }
                        S = (M * T) + Temp;
                        S = round(S);
                        System.out.println((int)S);
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
