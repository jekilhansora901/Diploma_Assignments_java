package assignment2;
public class UseStatic {
    static int a = 3;
    static int b;
    static void meth(int x) {
        b = a*4;
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    public static void main(String[] args) {
        meth(42);
    }
}
