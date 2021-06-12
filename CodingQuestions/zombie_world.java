import java.io.*;
import java.util.Scanner;
public class zombie_world {
    public static void main(String[] args) {
        int K, N, T, P, D, i,temp,j,k,ex,m;
        int E[];

        Scanner sc = new Scanner(System.in);
        K=sc.nextInt(); 
        if(K>=1 && K<=10)
        {
            for(m=0;m<K;m++)
            {
                N=sc.nextInt();
                if(N>=1 && N<=50)
                {
                    T=sc.nextInt();
                    if(T>=1 && T<=100 && T>=N)
                    {
                        E=new int[N];
                        for(i=0;i<N;i++)
                        {
                            E[i]=sc.nextInt();
                            if(!(E[i]>=1 && E[i]<=500))
                            {
                                System.out.println("No");
                                System.exit(1);
                            }
                        }
                        for(i=0;i<N;i++)
                        {
                            for(j=i+1;j<N;j++)
                            {
                                if(E[i]>E[j])
                                {
                                    ex=E[i];
                                    E[i]=E[j];
                                    E[j]=ex;
                                }
                            }
                        }
                        P=sc.nextInt();
                        if(P>=1 && P<=500)
                        {
                            D=sc.nextInt();
                            if(D>=1 && D<=2000)
                            {
                                temp=0;
                                for(i=0;i<N;i++)
                                {
                                    if(P>=E[i])
                                    {
                                        P=P+(P-E[i]);
                                        T--;
                                    }
                                    else
                                    {
                                        temp=1;
                                    }
                                }
                                if(temp==0 && T>=0)
                                {
                                    if(P>=D)
                                    {
                                        System.out.println("Yes");
                                    }
                                    else
                                    {
                                        System.out.println("No");
                                    }
                                    //System.out.println("Current Energy : "+P);
                                }
                                else
                                {
                                    System.out.println("No");
                                }
                            }
                            else
                            {
                                System.out.println("No");
                            }                        
                        }    
                        else
                        {
                            System.out.println("No");
                        }
                    }
                    else
                    {
                        System.out.println("No");
                    }
                }
                else
                {
                    System.out.println("No");
                }
            }
        }
        else
        {
            System.out.println("No");
        }
    }
}
