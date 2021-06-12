//Access Protection
class a 
{
    public int a=5;
    protected int b = 10;
    private int c = 15;
    void display()
    {
        System.out.println("Public : "+a);
        System.out.println("Protected : "+b);
        System.out.println("Private : "+c);
    }
}
class b extends a
{
    void displayb()
    {
        System.out.println("Public : "+a);
        System.out.println("Protected : "+b);
//        System.out.println("Private : "+c);// Private is not accessible in another class
    }
}
public class Access
{
    public static void main(String args[])
    {
        b s = new b();
        s.display();
        s.displayb();
    }
}