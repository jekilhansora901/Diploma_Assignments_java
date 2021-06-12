//super keyword use to call base class constructor
class a
{
    int a;
    a(int b)
    {
        a =b;
    }
}
public class SuperKeywordTest extends a
{
    double b;
    all(double t , int d)
    {
         super(d);//call base class constructor
         b = t;
    }
    void display()
    {
        System.out.println("Value of A : "+a); 
        System.out.println("Value of B : "+b);
    }
    public static void main(String args[])
    {
        all ob1 = new all(10.5,50);
        ob1.display();
    }
}