/*<applet code="9" height=200 width=300>
</apple>
*/
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class 9 extends Applet implements ActionListener
{
	Button red,green,blue;
	Label color;
	public void init()
	{
		red=new Button("Red");
		green=new Button("Green");
		blue=new Button("Blue");
		color=new Label("");
		add(red);
		add(green);
		add(blue);
		add(color);
		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
	}
	public void ActionPerformed(ActionEvent ae)
	{
		String cmd=ae.getActionCommand();
		if(cmd.equals("Red"))
		{
			setBackground(Color.RED);
			color.setText("RED");
		}
		else if(cmd.equals("Green"))
		{
			setBackground(Color.GREEN);
			color.setText("GREEN");
		}
		else if(cmd.equals("Blue"))
		{
			setBackground(Color.BLUE);
			color.setText("BLUE");
		}
		repaint();
	}
}