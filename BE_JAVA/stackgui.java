/*<applet code="stackgui" height=100 width=200>
</applet>
*/
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
public class stackgui extends Applet implements ActionListener
{
	Button ps,pp,so;
	TextField tx,ptx,stx;
	Stack ss;
	public void init()
	{
		ss=new Stack();
		Label stc=new Label("STACK : ");
		setLayout(new BorderLayout());
		Panel up=new Panel();
		Label st=new Label("Stack OperatioN");
		up.add(st);
		add(up,BorderLayout.NORTH);
		Panel op=new Panel();
		ps=new Button("Push");
		pp=new Button("Pop");
		so=new Button("Show");
		tx=new TextField(10);
		ptx=new TextField(10);
		stx=new TextField(10);
		op.setLayout(new GridLayout(3,2));
		op.add(tx);
		op.add(ps);
		op.add(pp);
		op.add(ptx);
		op.add(stc);
		op.add(stx);
		ps.addActionListener(this);
		pp.addActionListener(this);
		so.addActionListener(this);
		add(op,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String cmd=ae.getActionCommand();
		if(cmd.equals("Push"))
		{
			ss.push(new String(tx.getText()));
			showStatus(""+ss+"");
			tx.setText("");
			stx.setText(""+ss);
			ptx.setText("");
		}
		else if(cmd.equals("Pop"))
		{
			try
			{
				String s=(String) ss.pop();
				ptx.setText(s);
				showStatus(""+ss);
				stx.setText(""+ss);
			}
			catch(EmptyStackException e)
			{
				showStatus("Stack Is Empty..");
				ptx.setText("UnderFlow");
				stx.setText("UnderFlow");
				
			}
		}	
	}
			
	public void paint(Graphics g)
	{
	}	
}