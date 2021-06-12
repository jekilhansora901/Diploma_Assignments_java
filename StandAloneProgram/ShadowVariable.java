//Shadow Variable
class a
{
    int a =10;
    
}
public class ShadowVariable extends a
{
    double a = 5.5;
    void display()
    {
        System.out.println("Value of A : "+a);
    }
    public static void main(String args[])
    {
        all ob1 = new all();
        ob1.display();//hide the base class variable
    }
}