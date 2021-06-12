package assignment2;
import java.applet.*;
import java.awt.*;
public class diffshape extends Applet {
    public void paint(Graphics g)
    {
        g.drawLine(50,20,300,20);
        g.drawRect(60,30,70,120);
        g.fillRect(220,30,70,120);
        g.drawOval(140,30,50,50);
        g.fillOval(140,90,50,50);
    }
}
