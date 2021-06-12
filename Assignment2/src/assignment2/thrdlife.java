package assignment2;
//import java.lang.Thread;
//import java.io.*;
class ThreadDemo implements Runnable{
    Thread t;
    ThreadDemo(String s) {
    t=new Thread(this,s);
    t.start();//Ready to run
 }
 public void run() //Running state
 {
    System.out.println("In Run Method...");
    for(int i=0;i<2;i++) 
    {
        System.out.println("Thread Name :"+Thread.currentThread().getName());
    try
    {
        Thread.sleep(1000);//Blocked
    }
    catch(Exception e){}
    }
    System.out.println("Exit In Run Method...");
  }//Dead state
}
public class thrdlife
{
    public static void main(String args[])
    {
        System.out.println("In Main Method...");
        System.out.println("Thread Name :"+Thread.currentThread().getName());
        ThreadDemo m1=new ThreadDemo("My Thread 1");
        System.out.println("Exit In Main Method...");
    }
}