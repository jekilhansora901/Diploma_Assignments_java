import java.io.*;
public class sorting {

    public static void main(String[] args)throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int[] a=new int [5];
        int i,j,temp;
        System.out.println("Enter the 5 value : ");
        for(i=0;i<5;i++)
        {
            a[i] = Integer.parseInt(f.readLine());
        }
        for(i=0;i<5;i++)
        {
            for(j=i;j<5;j++)
            {
                if(a[i]>a[j])
                {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
                }
            }
        System.out.println("\t\t\tAfter Sorting  ...... ");
        System.out.println("\t\tAscending Order ...... ");
        for(i=0;i<5;i++)
        {
            System.out.println("Values : "+a[i]);
        } 
        }
    }
