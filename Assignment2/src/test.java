
import MyPack.*;
public class test {
    test(int a , int b)
    {
        System.out.println("Div of "+a+" / "+b+" = "+(a/b));
    }
    public static void main(String[] args) {
        sum f = new sum(15,5);
        sub s = new sub(15,5);
        mul t = new mul(4,5);
        test fr = new test(100,5);
    }
}
