/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appletExample;
import java.lang.Thread;
public class thrdcycle extends Thread
{
public void run()
{
    System.out.println("Entering into the Run() method");
    try
    {
    System.out.println("thred "+Thread.currentThread()+" is going to sleep");
    while(true)
    {
        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException x)
        {
        }
        System.out.println("Woke up again!!");
    }

}
    finally
    {

    System.out.println("Leaving the run() method");
    }
}
    public static void main(String args[])
    {
        System.out.println("Entering into the main() method");
        thrdcycle t = new thrdcycle();
        t.start();
        System.out.println("Leaving the main() method");
    }
}
