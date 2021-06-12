//Recursion Function call it self 
public class FactorialRecursive
{
    static int fact(int n)
    {
        int f;
        if(n==1)
            return n;
        else
        {
            f=fact(n-1)*n;//function call it self 
            return f;
        }
    }
    public static void main(String args[])
    {
        System.out.println("Factorial of 5 : "+fact(5));
    }
}
