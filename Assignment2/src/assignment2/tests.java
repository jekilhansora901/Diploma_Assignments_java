package assignment2;

class Super
{
    int x;
    Super(int x)
    {
        this.x = x;
}
void display()
{
    System.out.println("Super X : "+x);
}
}
class sub extends Super
{
    int y ;
    sub(int x , int y)
    {
        super(x);
        this.y=y;
    }
    void display()
    {
        System.out.println("Super x = "+x);
        System.out.println("Sub y = "+y);
    }
}
class tests
{
    public static void main(String args[])
    {
        sub s = new sub(100,200);
        s.display();
    }
}