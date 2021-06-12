//Exception handling try catch finally block simple or Unchecked Exception
public class ErrorHandlingTest
{
    public static void main(String agrs[])
    {
        int a=10,ans;
        try
        {
            ans = a/0;
            System.out.println("Answer : "+ans);
        }
        catch(ArithmeticException e)
        {
            System.out.println(e);//e is Exception handling object variable
        }
        finally
        {
            System.out.println("In Finally Block");
        }
    }
}