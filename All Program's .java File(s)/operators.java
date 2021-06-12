package assignments;
import java.io.*;
public class operators {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int a,b,c;
        System.out.println("Enter the value of A : ");  
        a=Integer.parseInt(f.readLine());
        System.out.println("Enter the value of B : ");  
        b=Integer.parseInt(f.readLine());
        System.out.println("\t\t\tArithmetic Operators .....");
        c=a+b;
        System.out.println("Sum (a+b) : "+c);
        c=a-b;
        System.out.println("Subtraction (a-b) : "+c);
        c=a*b;
        System.out.println("Multiplication (a*b) : "+c);
        System.out.println("Division (a/b) : "+a/b);
        System.out.println("Module (a%b) : "+a%b);
        System.out.println("\t\t\tInc - Dec Operators .....");
        System.out.println("Increment (a++) : "+ ++a);
        System.out.println("Decrement (a--) : "+ --a);
        System.out.println("\t\t\tBitWise Operators .....");
        System.out.println("Bitwise Not (~a) : "+ ~a);
        c=a&b;
        System.out.println("Bitwise And (a & b) : "+c);
        c=a|b;
        System.out.println("Bitwise Or (a | b) : "+c);
        c=a^b;
        System.out.println("Bitwise Exor (a ^ b) : "+c);
        a=25;
        c=a<<2;
        System.out.println("Bitwise Left Shift (a << 2) : "+c);
        c=a>>2;
        System.out.println("Bitwise Right Shift (a >> 2) : "+c);
        b=-25;
        c=b>>>2;
        System.out.println("Right Shift zero fill (b >>> 2) : "+c);
        System.out.println("\t\t\tRelational Operators .....");
        //a=25;
        //b=75;
        boolean ans;
        char c1='b',c2='d';
        ans = a==b;
        System.out.println("Equal to (a == b) : "+ans);
        ans = a!=b;
        System.out.println("Not Equal to (a != b) : "+ans);
        ans = a<b;
        System.out.println("Less than (a < b) : "+ans);
        ans = a>b;
        System.out.println("Greater than (a > b) : "+ans);
        double x=34.25,y=63.98;
        System.out.println(" X : "+x+" Y : "+y);
        System.out.println("\t\t\tLogical Operators .....");
        ans=(a>b)&(x<y);
        System.out.println("Logical And (a>b) & (x<y) : "+ans);
        ans=(a>b)|(x<y);
        System.out.println("Logical Or (a>b) | (x<y) : "+ans);
        ans=(c1==c2)^(b>100);
        System.out.println("Logical XOR(c1==c2)^(b<100) : "+ans);
        ans=(a>b)&&(x<y);
        System.out.println("Short Circuit And (a>b) && (x<y) : "+ans);
        ans=(a>b)||(x<y);
        System.out.println("Short Circuit OR (a>b) || (x<y) : "+ans);
        
    }
}
