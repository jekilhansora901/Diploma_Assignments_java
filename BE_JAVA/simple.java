/*
<applet code="simple.class" width=300 height=300>
</applet>
*/
import java.awt.*;
import java.applet.*;

public class simple extends Applet implements Runnable
{
	String msg=" A Reading is Going on.. ";
	Thread t=null;
	int state;
	boolean stopflag;
	public void init()
	{
		setBackground(Color.cyan);
		setForeground(Color.red);
		start();
	}
	public void start()
	{
		t=new Thread(this);
		stopflag=false;
		t.start();
	}
	public void run()
	{
		char ch;
		for(;;)
		{
			try
			{
				repaint();
				Thread.sleep(250);
				ch=msg.charAt(0);
				msg=msg.substring(1,msg.length());
				msg+=ch;
				if(stopflag)	break;
			}
			catch(InterruptedException e)
			{}
		}
	}
	public void stop()
	{
		stopflag=true;
		t=null;
	}
	public void paint(Graphics g)
	{
		g.drawString(msg,50,30);
	}
}