//super keyword use to access base class variable
class a
{
    int a =10;
    
}
public class SuperVarTest extends a
{
    double a = 5.5;
    void display()
    {
        System.out.println("Value of A : "+a);//print local a 
        System.out.println("Value of Base Class A : "+super.a);//print base class variable a
    }
    public static void main(String args[])
    {
        all ob1 = new all();
        ob1.display();
    }
}