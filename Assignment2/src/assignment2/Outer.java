package assignment2;
public class Outer {
    int outer_x = 100;
    void test() {
        Inner inner = new Inner();
        inner.inner_y=200;
        inner.display();
    }
    class Inner {
        int inner_y;
        void display() {
            System.out.println("Outer_x = " + outer_x);
            System.out.println("Inner_y = " + inner_y);
        }
    }
    public static void main(String[] args) {
        Outer o = new Outer();
        o.test();
    }
}
