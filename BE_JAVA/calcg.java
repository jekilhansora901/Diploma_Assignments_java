/*<applet code="calcg" height=200 width=170>
</applet>
*/
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class calcg extends Applet implements ActionListener
{
	int ans;
	TextField n1,n2;
	Button addi,sub,mul,div;
	public void init()
	{
		Label no1=new Label("Number 1");
		Label no2=new Label("Number 2");
		n1=new TextField(5);
		n2=new TextField(5);
		addi=new Button("Add");
		sub=new Button("Sub");
		mul=new Button("Mul");
		div=new Button("Div");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(no1);
		add(n1);
		add(no2);
		add(n2);
		add(addi);
		add(sub);
		add(mul);
		add(div);
		
		addi.addActionListener(this);
		sub.addActionListener(this);
		div.addActionListener(this);
		mul.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str=ae.getActionCommand();
		if(str.equals("Add"))
		{
			ans=Integer.parseInt(n1.getText())+Integer.parseInt(n2.getText());
		}
		else if(str.equals("Sub"))
		{
			ans=Integer.parseInt(n1.getText())-Integer.parseInt(n2.getText());
		}
		else if(str.equals("Mul"))
		{
			ans=Integer.parseInt(n1.getText())*Integer.parseInt(n2.getText());
		}
		else if(str.equals("Div"))
		{
			ans=Integer.parseInt(n1.getText())/Integer.parseInt(n2.getText());
		}
		repaint();
	}
	public void paint(Graphics g)
	{
		String msg=" "+ans;
		showStatus(msg);
	}
}
		