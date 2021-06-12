//Single level Inheritance
class a
{
    int a , b;
    void getdata(int a , int b)
    {
        this.a = a;
        this.b = b;
    }
}
public class Inheritance extends a
{
    void display()
    {
        System.out.println("Value of A : "+a);
        System.out.println("Value of B : "+b);
    }
    public static void main(String args[])
    {
        Inheritance ob1 = new Inheritance();
        ob1.getdata(10,15); //called base class method
        ob1.display();
    }
}