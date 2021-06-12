class a
{
    int sum(int x,int y)
    {
        return x+y;
    }
    double sum(double x , double y)//overload sum method
    {
        return x+y;
    }
}
public class MethodOverloadTest extends a
{
    public static void main(String args[])
    {
        a ob1 = new a();
        System.out.println("Sum of 5 + 10 = "+ob1.sum(5,10));//call int sum method
        System.out.println("Sum of 5.5 + 10.5 = "+ob1.sum(5.5, 10.5));//call double sum method
    }
}