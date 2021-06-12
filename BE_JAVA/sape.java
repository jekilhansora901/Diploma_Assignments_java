/*<applet code="sape" height=200 width=170>
</applet>
*/
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class sape extends Applet
{
	public void init()
	{
		start();
	}
	public void paint(Graphics g)
	{
		g.drawOval(0,0,150,150);
		g.drawLine(75,0,0,75);
		g.drawLine(75,0,150,75);
		g.drawLine(0,75,75,150);
		g.drawLine(75,150,150,75);
		g.drawOval(35,35,80,80);
		
	}
}