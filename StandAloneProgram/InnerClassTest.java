//Inner class
class out
{
    int i;
    void display()
    {
        in ob = new in(); // create inner class object
        ob.a= 100;
        ob.display();//access class method with in method
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
public class InnerClassTest
{
    public static void main(String args[])
    {
        out o = new out();
        o.i=10;
        o.display();
    }
}