package assignment2;
import java.io.*;
public class salary {
    double basic,da,hra,gross,gpf,net;
    String name;
    void getdata()throws IOException
    {
        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        System.out.print("Enter Name : ");
        name = bf.readLine();
        System.out.print("Enter Basic Salary : ");
        basic = Double.parseDouble(bf.readLine());    
    }
    void calculate()
    {
        da = basic * 0.60;
        hra = gross * 0.30;
        gross = basic + da + hra;
        gpf = basic * 0.10;
        net = gross - gpf;
    }
    void display()
    {
        System.out.println("Name : "+name);
        System.out.println("Basic Salary : "+basic);
        System.out.println("Total Salary : "+net);
    }
    public static void main(String[] args)throws IOException {
        salary s1[]=new salary[5];
        int i;
        for(i=0;i<5;i++)
        {
            s1[i]=new salary();
            s1[i].getdata();
            s1[i].calculate();
        }
        for(i=0;i<5;i++)
        {
            s1[i].display();
        }
    }
}
