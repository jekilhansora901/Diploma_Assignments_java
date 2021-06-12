import java.util.Scanner;
public class occurence { 
    public static void main(String[] args) {
        try
        {
        Scanner s = new Scanner(System.in);
        String[] range;
        String input;
        long k=0;
        Scanner st = new Scanner(System.in);
        long test = st.nextInt();
        int result[] = new int[(int)test];
        input=s.nextLine();
        range=input.split(" ");
        int start=Integer.parseInt(range[0]);
        int end=Integer.parseInt(range[1]);
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
            choice=input.charAt(0);
            if(choice=='A')
            {
                digit=(int) input.charAt(1);
                for(int j=start;j<=end;j++)
                {
                    sort=Integer.toString(j);
                    int b=a_opp(sort,digit);
                    if(b==1)
                    {
                        count++;
                    }
                }
                System.out.println(count);
                result[(int)k]=count;
            }
            else if(choice=='C')
            {
                frq=(int) input.charAt(1);
                digit=(int) input.charAt(2);
                frq=frq-48;
                digit-=48;
                for(int j=start;j<=end;j++)
                {
                    sort=Integer.toString(j);
                    int b=cons(sort,frq,digit);
                    if(b==1)
                    {
                        count++;
                    }
                }
                System.out.println(count);
                result[(int)k]=count;
            }
            else
            {
                int j=0;
                for(int i=0;i<=input.length()-1;i++)
                {
                    digit1[i]=input.charAt(i);
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
                result[(int)k]=count;
            }
            k++;
        }
        }
        catch(Exception e)
        {
            System.out.println("Invalid Input");
        }
    }
    public static int a_opp(String str,int d)
    {
        char first, second;
        int a=0;
        for(int i=0; i<str.length()-2; i++)
        {
           first= str.charAt(i);
           if(first==d)
           {
           second= str.charAt(i+2);
           if(first==second)
           {
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
    
    public static int cons(String str,int f,int d)
    {
        char first;
        int a=0,a1=0;
        for(int i=0; i<str.length()-(f-1); i++){
           first=str.charAt(i);
           if((int)first==d+48)
           {
               for(int j=0;j<f;j++)
               {
                   if((int)str.charAt(i+j)==d+48)
                   {
                       a++;
                   }
                   else
                   {
                       a1=1;
                   }
               }
           }
        }
        if(a1==0)
           if(a==f)
           {
               return 1;
           }
           else
           {
               return 0;
           } 
        return 0;
    }   
}