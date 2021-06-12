//Multilevel Inheritance
class a
{
    void methoda ()
    {
        System.out.println("In Class A .");
    }
}
class b extends a
{
    void methodb()
    {
        System.out.println("In Class B .");
    }
}
class c extends b
{
    void methodc()
    {
        System.out.println("In Class C .");
    }
}
public class MultilevelInheritance
{
    public static void main(String s[])
    {
        c ob = new c();
        System.out.println("Method Called By Class C.");
        ob.methoda();
        ob.methodb();
        ob.methodc();
    }
}