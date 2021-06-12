
package assignment2;

public class multiplecatch {

    public static void main(String[] args) {
    int d, ans;
    try 
    {
        d = 0;
        ans = 10 / d;
        System.out.println("This will not be printed.");
        int array[] = {10,20,30,40};
        array[5]=50;
    } 
    catch(ArithmeticException e) 
    { 
       System.out.println("Division by zero.");
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
        System.out.println("Array Index is out of bound");
    }
    }
}
