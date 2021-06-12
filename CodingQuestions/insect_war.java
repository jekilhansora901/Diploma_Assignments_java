
import java.util.Scanner;

public class insect_war {
   public static void main(String[] args) {
       try
       {
        int n;
        Scanner st = new Scanner (System.in);
        Scanner s = new Scanner (System.in);
        n = st.nextInt();
        int k;
        String[] range;
        String input;
       
        k=0;
        while(k<n)
        {
            long x,y,t;
            input=s.nextLine();
            range=input.split(" ");
            x=Long.parseLong(range[0]);
            y=Long.parseLong(range[1]);
            t=Long.parseLong(range[2]);
            
            long insect[]=new long[10000000];
            insect[0]=x;
            insect[1]=y;
            int l,i,j;
            for(i=0,j=2;i<t;i++,j++)
            {
                l=0;
                while(l<j-1)
                {
                    insect[j] += insect[l]*2;
                    l++;
                    if(l==j-1)
                    {
                        insect[j]+=insect[j-1];
                    }
                }
            }
            System.out.println((insect[j-1]));
            k++;
        }
    }
       catch(Exception e)
       {
           System.out.println("Invalid Input");
       }
   }
}
