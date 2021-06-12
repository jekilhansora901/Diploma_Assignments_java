/*<applet code="linkgui" height=200 width=400>
</applet>
*/
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
public class linkgui extends Applet implements ActionListener,ItemListener
{
	Checkbox af,al,a,df,dl,d;
	CheckboxGroup aadd,del;
	Button in,dlb;
	TextField tx,lis;
	LinkedList ll;
	String seladd,seldel;
	public void init()
	{
		ll=new LinkedList();
		Label stc=new Label("LIST : ");
		setLayout(new BorderLayout());
		Panel up=new Panel();
		Label st=new Label("Link List OperatioN");
		up.add(st);
		add(up,BorderLayout.NORTH);
		tx=new TextField(20);
		Label ennn=new Label("Enter Data ");
		lis=new TextField(25);
		lis.setText(""+ll);
		Panel tt=new Panel();
		tt.setLayout(new GridLayout(2,2));
		tt.add(stc);
		tt.add(lis);
		tt.add(ennn);
		tt.add(tx);
		add(tt,BorderLayout.CENTER);
				
		Panel op=new Panel();
		op.setLayout(new GridLayout(2,4));
		aadd=new CheckboxGroup();
		del=new CheckboxGroup();
		af=new Checkbox("Add First",aadd,false);
		a=new Checkbox("Add",aadd,true);
		al=new Checkbox("Add Last",aadd,false);
		in=new Button("Insert");
		dlb=new Button("Delete");
		df=new Checkbox("Delete First",del,false);
		dl=new Checkbox("Delete Last",del,true);
		d=new Checkbox("Delete",del,false);
		op.add(af);
		op.add(a);
		op.add(al);
		op.add(in);
		op.add(df);
		op.add(d);
		op.add(dl);
		op.add(dlb);
		af.addItemListener(this);
		al.addItemListener(this);
		a.addItemListener(this);
		df.addItemListener(this);
		dl.addItemListener(this);
		d.addItemListener(this);
		in.addActionListener(this);
		dlb.addActionListener(this);
		add(op,BorderLayout.SOUTH);
		seladd=aadd.getSelectedCheckbox().getLabel();
		seldel=del.getSelectedCheckbox().getLabel();
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String cmd=ae.getActionCommand();
		if(cmd.equals("Insert"))
		{
			switch(seladd)
			{
				case "Add" :ll.add(tx.getText());
							break;
				case "Add First" :  ll.addFirst(tx.getText());
									break;
				case "Add Last" :   ll.addLast(tx.getText());
									break;
			}
			showStatus(""+ll);
			lis.setText(""+ll);
		}
		else if(cmd.equals("Delete"))
		{
			switch(seldel)
			{
				case "Delete" :ll.remove(tx.getText());
							break;
				case "Delete First" :  ll.removeFirst();
									break;
				case "Delete Last" :   ll.removeLast();
									break;
			}
			showStatus(""+ll);
			lis.setText(""+ll);
		}
		repaint();
	}
	public void itemStateChanged(ItemEvent ie)
	{
		seladd=aadd.getSelectedCheckbox().getLabel();
		seldel=del.getSelectedCheckbox().getLabel();
		repaint();
	}
	public void paint(Graphics g)
	{
		seladd=aadd.getSelectedCheckbox().getLabel();
		seldel=del.getSelectedCheckbox().getLabel();
		
	}	
}