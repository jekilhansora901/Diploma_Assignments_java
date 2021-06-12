package assignment2;
import java.applet.*;
import java.awt.*;
public class aplife extends Applet {
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
    public void paint(Graphics g)
    {
        g.drawString("Welcome to Applet", 100, 50);
        System.out.println("Applet Paint() method ...");
    }
}
