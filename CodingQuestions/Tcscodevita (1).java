
package tcscodevita;

import java.util.Arrays;
import java.util.Scanner;

public class Tcscodevita {

   
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] range;
        String input;
        long k=0;
        //getting value of test cases
         //System.out.println("Enter test cases:");
         Scanner st = new Scanner(System.in);
        long test = st.nextInt();
        
        
        //System.out.println("Enter string:");
        input=s.nextLine();
        range=input.split(" ");
        int start=Integer.parseInt(range[0]);
        int end=Integer.parseInt(range[1]);
       // System.out.println(range[0]+" "+range[1]);
        while(k<test)
        {
        char choice;
        int digit=0;
        char digit1[];
        digit1= new char[10];
        String sort;
        
        int count=0;
        int frq=0;
        
            
            input=s.nextLine();
            choice=Character.valueOf(input.charAt(0));
            if(choice=='A')
            {
                digit=Integer.valueOf(input.charAt(1));
                for(int j=start;j<=end;j++)
                {
                    sort=Integer.toString(j);
                    int b=solve(sort,digit);
                    if(b==1)
                    {
                        count++;
                    }
                }
                System.out.println(count);
            }
            else if(choice=='C')
            {
                frq=Integer.valueOf(input.charAt(1));
                digit=Integer.valueOf(input.charAt(2));
                for(int j=start;j<=end;j++)
                {
                    sort=Integer.toString(j);
                    int b=solve1(sort,frq,digit);
                    if(b==1)
                    {
                        count++;
                    }
                }
                System.out.println(count);
            }
            else
            {
                int j=0;
                for(int i=0;i<=input.length()-1;i++)
                {
                    digit1[i]=Character.valueOf(input.charAt(i));
                    if(digit1[i]=='W')
                    {
                        if(j==0)
                        {
                        count=count+10;
                        j=i;
                        }
                        else if(j==i-1)
                        {
                            count=count*10;
                        }
                        
                    }
                }
                System.out.println(count);    
            }
            k++;
        }
    }
    public static int solve(String str,int d){
    char first, second;
    int a=0;
    for(int i=0; i<str.length()-2; i++){
       first= str.charAt(i);
       if(first==d)
       {
       second= str.charAt(i+2);
       if(first==second){
        a++;   
        break;
       }
       }
    }
       if(a==0)
       {
           return 0;
       }
       else
       {
           return 1;
       }       
    }
    
     public static int solve1(String str,int f,int d){
    char first, second[];
    int a=0,a1=0;
    int limit=0;
    for(int i=0; i<str.length()-f; i++){
       first= str.charAt(i);
       if(first==d)
       {
           if(a1==0)
           {
           a++;
           a1=i;
               System.out.println("inner"+a+" " +a1);
           }
           else if(a1==i-1)
           {
               a++;
               a1=i;
                System.out.println("outer"+a+" " +a1);
           }
       }
       }
       if(a==f-1)
       {
           return 1;
       }
       else
       {
           return 0;
       }       
    }   
}

