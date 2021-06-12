package assignment2;
public class time {
    private int hh , mm , ss,ts,tm,th;
    time()
    {
        hh = 0;
        mm = 0;
        ss = 0;
    }
    time(int a , int b , int c)
    {
        hh = a;
        mm = b;
        ss = c;
    }
    time add(time a , time b)
    {
        hh = a.hh + b.hh;
        mm = a.mm + b.mm;
        ss = a.ss + b.ss;
        ts = ss /60;
        ss = ss%60;
        mm = mm + ts;
        tm = mm / 60;
        mm = mm%60;
        hh = hh + tm;
        
        return this;
    }
    void display()
    {
        System.out.println(" Time : "+hh+":"+mm+":"+ss);
    }
}
class test
{
    public static void main(String[] args) {
        time a = new time(3,38,40);
        time b = new time(7,42,50);
        time c = new time();
        c = c.add(a, b);
        System.out.println("For Object 1 :  ");
        a.display();
        System.out.println("For Object 2 :  ");
        b.display();
        System.out.println("Sum of Object 1 + Object 2 :  ");
        c.display();
    }
}
