interface add
{
    void sum();
}
class sumi implements add
{
    public void sum()//implement method of interface
    {
        System.out.println("Sum of 5+10:"+(5+10));
    }
}
class sumd implements add
{
    public void sum()//implement method of interface
    {
        System.out.println("Sum of 5.2+10.8:"+(5.2+10.8));
    }
}
public class InterfaceImpl
{
    public static void main(String args[])
    {
        sumi a = new sumi();
        sumd b = new sumd();
        a.sum();
        b.sum();
    }
}