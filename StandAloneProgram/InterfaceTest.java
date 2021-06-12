//extends interface
interface getdat
{
    public void getdata();
}
interface add extends getdat
{
    public void sum();
}
class sumi implements add
{
    int a , b;
    public void getdata()
    {
        a=10;
        b=15;
    }
    public void sum()
    {
        System.out.println("Sum of "+a+"+"+b+"="+(a+b));
    }
}
class sumd implements add
{
    double a , b;
    public void getdata()
    {
        a=10.5;
        b=15.5;
    }

    public void sum()
    {
        System.out.println("Sum of "+a+"+"+b+"="+(a+b));
    }
}
public class InterfaceTest
{
    public static void main(String args[])
    {
        sumi a = new sumi();
        sumd b = new sumd();
        a.getdata();
        b.getdata();
        a.sum();
        b.sum();
    }
}