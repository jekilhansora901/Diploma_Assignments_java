package assignment2;
import java.io.*;
public class box {
    double width,height,depth,volume;
    box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }
    void calanddis()
    {
        volume= width * height * depth;
        System.out.println("Width : "+width+" Height : "+height+" Depth : "+depth);
        System.out.println("Volume : "+volume);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        box [] b1 =new box[5];
        int i;
        double w,h,d;
        for(i=0;i<5;i++)
        {
            System.out.println("For Object "+(i+1));
            System.out.print("Enter width : ");
            w=Double.parseDouble(bf.readLine());
            System.out.print("Enter Hieght : ");
            h=Double.parseDouble(bf.readLine());
            System.out.print("Enter Depth : ");
            d=Double.parseDouble(bf.readLine());
            b1[i]=new box(w,h,d);
        }
        System.out.println("\t\t\tVolume of Boxes");
        for(i=0;i<5;i++)
        {
            System.out.println("For Object "+(i+1));
            b1[i].calanddis();
        }
    }
}