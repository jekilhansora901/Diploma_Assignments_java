/*<applet code="test.class" width=200 height=200>
</applet>*/
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class test extends Applet implements MouseListener
{
	int x,y;
	public void init()
	{
		this.addMouseListener(this);
		start();
	}
	public void mouseClicked(MouseEvent e)
	{
		x=e.getX();
		y=e.getY();
		repaint();
	}	
	public void mouseReleased(MouseEvent e)
	{
	}
	public void mousePressed(MouseEvent e)
	{
	}
	public void mouseExited(MouseEvent e)
	{
	}
	public void mouseEntered(MouseEvent e)
	{
	}
	public void paint(Graphics g)
	{
		g.drawString("You're Here",x,y);
	}
}