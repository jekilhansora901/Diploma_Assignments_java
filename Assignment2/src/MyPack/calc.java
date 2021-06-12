//package MyPack;
import MyPack.*;
public class calc {
    calc(int a , int b)
    {
        System.out.println("Div of "+a+" / "+b+" = "+(a/b));
    }
    public static void main(String[] args) {
        sum f = new sum(15,5);
        sub s = new sub(25,5);
        mul t = new mul(4,5);
        calc fr = new calc(100,5);
    }
}
