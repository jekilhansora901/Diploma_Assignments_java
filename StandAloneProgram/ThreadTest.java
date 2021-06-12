//simple thread 
import java.lang.Thread;
public class ThreadTest extends Thread
{
    ThreadTest()
    {
       System.out.println("IN Default Constructor.");
       start();//to call run method or to start thread
    }
    public void run()
    {
        System.out.println("IN the RUN method...");
    }
    public static void main(String argsp[])
    {
        ThreadTest d = new ThreadTest();
    }
}