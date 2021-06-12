//static keyword
class abc
{
    static int a;
    static void display()
    {
        System.out.println("Static Variable A : "+a);//static method access only static variable
    }
}
public class StaticTest
{
    public static void main(String args[])
    {
        abc.display();
        abc.a=100;//static member access throw class 
        abc.display();//static method without any refference of class
    }
}