
package assignment2;
import java.io.*;
import java.lang.Thread;
public class thrdpriority implements Runnable 
{
    public void run()
    {
        System.out.println("Thread is Running");
    }
    public static void main(String[] args) {
        thrdpriority t1 = new thrdpriority();
        Thread p1 = new Thread(t1);
        Thread p2 = new Thread(t1);
        System.out.println("Priority of P1 : "+p1.getPriority());
        p1.setPriority(2);
        p1.start();
        p2.start();
        System.out.println("Priority of P1 : "+p1.getPriority());        
        System.out.println("Priority of P2 : "+p2.getPriority());                
  }
}
