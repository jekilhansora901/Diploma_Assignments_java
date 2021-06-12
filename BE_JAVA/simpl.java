import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*<applet code="simpl" height=300 width=500>
</applet>
*/
public class simpl extends Applet implements ActionListener, ItemListener
{
	String msg;
	Button b1,b2;
	Checkbox c1,c2;
	CheckboxGroup cg;
	Choice os;
	List name;
	TextField ns;
	public void init()
	{
		Label one=new Label("One");
		Label two=new Label("two");
		add(one);
		add(two);
		
		b1=new Button("XP");
		b2=new Button("No");
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		cg=new CheckboxGroup();
		c1=new Checkbox("Windows XP",cg,false);
		c2=new Checkbox("Windows 8.1",cg,false);
		add(c1);
		add(c2);
		c1.addItemListener(this);
		c2.addItemListener(this);
		os=new Choice();
		os.add("Windows 8");
		os.add("Windows 8.1");
		os.add("Windows XP");
		os.add("Windows 10");
		add(os);
		os.addItemListener(this);
		name=new List(4,true);
		name.add("Jekil");
		name.add("Akshay");
		name.add("Anand");
		name.add("Akky");
		add(name);
		name.addActionListener(this);
		ns=new TextField(10);
		add(ns);
		ns.addActionListener(this);
	}
	public void itemStateChanged(ItemEvent ie)
	{
		os.select(cg.getSelectedCheckbox().getLabel());
		repaint();
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str=ae.getActionCommand();
		if(str.equals("XP"))
			{
				msg="Button b1";
				os.select("Windows XP");
				c1.setState(true);
			}
		else
			msg="Button b2";
			int idx[];
		msg="Name : ";
		idx=name.getSelectedIndexes();
		for(int i=0;i<idx.length;i++)
			msg+=name.getItem(idx[i])+" ";
		ns.setText(msg);
		repaint();
	}
	public void paint(Graphics g)
	{
		msg="C1 : "+c1.getState()+" C2 : "+c2.getState();
		g.drawString(msg,30,100);
		msg="Current Selection : "+cg.getSelectedCheckbox().getLabel();
		g.drawString(msg,30,150);
		msg="Current Os :"+os.getSelectedItem();
		g.drawString(msg,30,170);
		int idx[];
		msg="Name : ";
		idx=name.getSelectedIndexes();
		for(int i=0;i<idx.length;i++)
			msg+=name.getItem(idx[i])+" ";
		g.drawString(msg,30,180);
		msg=ns.getText();
		g.drawString(msg,30,200);
	}
}
		