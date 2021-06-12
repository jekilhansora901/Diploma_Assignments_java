package appletExample;
import java.applet.*;
public class aplife extends Applet
{
    public aplife()
    {
        System.out.println("Applet Constructed...");
    }
    public void init()
    {
        System.out.println("Applet Initialized...");
    }
    public void start()
    {
        System.out.println("Applet Started...");
    }
    public void stop()
    {
        System.out.println("Applet Stopped...");
    }
    public void destroy()
    {
        System.out.println("Applet Destroyed...");
    }
}