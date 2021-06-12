class a
{
    int d;
    a()
    {
        d=10;
    }
    void display()
    {
        System.out.println("Base Class D : "+d);
    }
}
class b extends a
{
    int s;
   b(int y)
    {
        super();//call base class constructor
        s= y;
    }
   void display()//override base class method display()
   {
       System.out.println("Base class Variable D :"+d);
       System.out.println("Derive class Variable S : "+s);
   }
}
public class MethodOverrideExample extends a
{
    public static void main(String args[])
    {
        b ob1 = new b(100);
        ob1.display();
    }
}