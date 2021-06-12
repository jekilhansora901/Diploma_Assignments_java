package assignment2;
public class MethodOver {
    void test() {
        System.out.println("No parameters");
    }
    void test(int a) {
        System.out.println("a: " + a);
    }
    void test(int a, int b) {
        System.out.println("x and y: " + a + " " + b);
    }
    public static void main(String[] args) {
        MethodOver o = new MethodOver();
        o.test();
        o.test(10);
        o.test(50, 50);
    }
}
