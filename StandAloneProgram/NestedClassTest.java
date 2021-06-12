//Nested class
class out
{
    int i;
    void display()
    {
        System.out.println("Value of Outter I : "+i);
    }
    class in
    {
        int a;
        void display()
        {
            System.out.println("Value of Inner A : "+a);
        }
    }
}
public class NestedClassTest
{
    public static void main(String args[])
    {
        out o = new out();
        o.i=10;
        o.display();
        //o.a=100//not access 
        out.in ob = o.new in();//create nested class object throw outter class
        ob.a=50;
        ob.display();
    }
}