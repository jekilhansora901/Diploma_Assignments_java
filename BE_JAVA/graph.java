/*<applet code="graph" width=400 height=600>
</applet>
*/
import java.awt.*;
import java.applet.*;

public class graph extends Applet 
{
	String msg;
	int n,fx,fy,sx,sy,dx,dy,dxx,dyy;
	public void init()
	{
		msg="ILOVEYOU";
		n=5;
		fx=10;
		fy=10;
		sx=0;
		start();
	}
	public void paint(Graphics g)
	{
		int tmp=1,k=0;
		int flag=0,f=0;
		int in,j=0;
		for(int i=0;i<msg.length();i++)
		{
			if(f==0)
			{
				if(flag==1)
				{
					fy=fy+50;
					g.drawLine(dx,dy,fx+15,fy+15);
					flag=0;
					tmp++;
				}	
				g.drawString(""+msg.charAt(j++),fx+16,fy);
				
				g.drawOval(fx,fy,30,30);
				sx=fx+50;
				g.drawOval(sx,fy,30,30);
				
				tmp++;
				dx=fx+15;
				dy=fy+15;
				dxx=sx+15;
				dyy=fy+15;
				g.drawLine(dx,dy,dxx,dyy);
				fx+=50;
				
				if(tmp%8==0)
				{
					g.drawString(""+msg.charAt(j++),fx+16,fy);
					f=1;
				}
			}
			else
			{

				if(flag==0)
				{
					fy=fy+50;
					g.drawLine(dxx,dyy,fx+15,fy+15);
					flag=1;
				}
				
				g.drawOval(fx,fy,30,30);
				g.drawString(""+msg.charAt(j++),fx+16,fy);

				sx=fx-50;
				tmp++;
				g.drawOval(sx,fy,30,30);
				
				dx=fx+15;
				dy=fy+15;
				dxx=sx+15;
				dyy=fy+15;
				if(tmp%8==0)
					f=0;
				else
				{
				g.drawLine(dx,dy,dxx,dyy);
				fx=fx-50;
				}
			}
		}
	}
}
	