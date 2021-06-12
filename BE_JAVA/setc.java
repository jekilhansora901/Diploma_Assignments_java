/*<applet code="setc" height=300 width=200>
</applet>
*/
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class setc extends Applet implements AdjustmentListener//, MouseMotionListener
{
	Scrollbar red,green,blue;
	Label rl,bl,gl;
	public void init()
	{
		red=new Scrollbar(Scrollbar.HORIZONTAL,20,20,20,555);
		green=new Scrollbar(Scrollbar.HORIZONTAL,0,2,0,255);
		blue=new Scrollbar(Scrollbar.HORIZONTAL,0,2,0,255);
		rl=new Label("Red");
		bl=new Label("Blue");
		gl=new Label("Green");
		add(rl);
		add(red);
		add(gl);
		add(green);
		add(bl);
		add(blue);
		red.addAdjustmentListener(this);
		green.addAdjustmentListener(this);
		blue.addAdjustmentListener(this);
		//addMouseMotionListener(this);
	}
	public void adjustmentValueChanged(AdjustmentEvent ae)
	{
		repaint();
	}
	public void paint(Graphics g)
	{
		Color c=new Color(red.getValue(),green.getValue(),blue.getValue());
		setBackground(c);
	}
}
	