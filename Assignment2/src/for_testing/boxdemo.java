/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package for_testing;
import java.io.*;
class box
{
    double l,b,w,area,weight;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void getdata() throws IOException
    {
        System.out.print("Enter Lenght :");
        l= Double.parseDouble(br.readLine());
        System.out.print("Enter Breath: ");
        b= Double.parseDouble(br.readLine());
         System.out.print("Enter Lenght :");
         w= Double.parseDouble(br.readLine());
    }
   
}
class box_weight extends box
{
   
     void process()
    {
        area = l*b;
        weight = l*b*w;
    }
    void display()
    {
        System.out.println("Area : "+area);
        System.out.println("Box Weight : "+weight);
    }
}
public class boxdemo
{
     public static void main(String args[]) throws IOException
    {
        box_weight b = new box_weight();
      b.getdata();
        b.process();
       b.display();
       
    }
}

