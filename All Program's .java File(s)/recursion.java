package assignment2;
public class recursion {
    static int fact(int a)
    {
        int n;
        if(a==1)
        {
            return 1;
        }
        else
        {
            n = fact(a-1)*a;
            return n;
        }
    }
    public static void main(String[] args) {
        int f,no=5;
        f = fact(no);
        System.out.println("Factorial Of "+no+" : "+f);
    }
}