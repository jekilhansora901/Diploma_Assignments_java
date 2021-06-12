//simple thread using implementation
public class ThreadImplTest implements Runnable
{
    Thread t;//declare thread object
    ThreadImplTest()
    {
       System.out.println("IN Default Constructor.");
       t = new Thread(this); //initialize thread
       t.start();//to start thread
    }
    public void run()
    {
        System.out.println("IN the RUN method...");
    }
    public static void main(String argsp[])
    {
        ThreadImplTest d = new ThreadImplTest();
    }
}