//get name or set name method
public class ThreadName extends Thread
{
     Thread t;//declare thread object
    all()
    {
       System.out.println("IN Default Constructor.");
       t = new Thread();//create new thread
       System.out.println("Thread Name : "+t.getName());
       t.setName("Test");//set the name of Thread-0
       System.out.println("Thread NAme : "+t.getName());
       t=Thread.currentThread();//it shows main thread
       System.out.println("Thread Name : "+t.getName());
    }
    public void run()
    {
        System.out.println("IN the RUN method...");
    }
    public static void main(String args[])
    {
        all d = new all();
        d.start();//start thread
    }
}