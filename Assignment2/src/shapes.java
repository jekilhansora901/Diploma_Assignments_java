import java.applet.Applet;
import java.awt.*;
public class shapes extends Applet
{
   public void paint(Graphics g)
    {
        int x1[] = {150,175,200,225,250,325};
        int y1[] = {325,150,275,140,230,150};
        int x2[] = {350,400,375,450,500};
        int y2[] = {180,275,200,125,300};

        g.setColor(Color.green);
        g.drawLine(20, 10,60,10);
        g.drawOval(300, 10, 60, 40);
        g.drawRect(40,70, 30, 50);
        g.drawRoundRect(50, 170,30,50,20,20);
        g.draw3DRect(120,10,50,30,true);
        g.drawArc(400,50,100,70,30,80);
        g.fillArc(200,80,100,70,80,100);
        g.drawPolyline(x2, y2, 6);
        g.setColor(Color.red);
        g.fillPolygon(x2,y2,5);
        showStatus("this applet shows figure");
    }

   
}
