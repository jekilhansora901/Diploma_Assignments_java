
package assignment2;

class expction {
    public static void main(String args[]) {
    int d, ans;
    try 
    {
        d = 0;
        ans = 10 / d;
        System.out.println("This will not printed.");
    } 
    catch (ArithmeticException a) 
    { 
       System.out.println("Division by zero.");
    }
    System.out.println("After Arithmetic catch statement.");
    try
    {
        int array[] = {10,20,30,40};
        array[5]=50;
    }
    catch(ArrayIndexOutOfBoundsException ea)
    {
        System.out.println("Array is out of bound");
    }
    System.out.println("After Array catch statement.");
}
}