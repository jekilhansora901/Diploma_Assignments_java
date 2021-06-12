package appletExample;
import java.applet.*;
import java.awt.*;
public class msg extends Applet{
    public void paint(Graphics g)
    {
        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);
        Font f = new Font("Hansen__",Font.BOLD,25);
        g.setFont(f);
        g.drawString("Java Applet Programming", 10, 30);
        Color c = Color.BLACK;
        setBackground(c);
        g.drawRect(5,5,315,35);
        g.fillRect(80, 80, 140, 160);
    }
}
