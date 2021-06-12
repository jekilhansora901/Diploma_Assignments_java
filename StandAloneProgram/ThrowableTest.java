//throwable exception
public class ThrowableTest
{
    public static void main(String agrs[])
    {
        Throwable note = new Throwable("You are not Elegeble");
        
        try
        {
            int a=10;
            
            if(!(a>18))throw note;//if condition false then it go to catch
            {
                System.out.println("Pls Vote...");
            }
        }
        catch(Throwable e)
        {
            System.out.println(e);
        }
    }
}