/*<applet code="calculator" height=200 width=170>
</applet>
*/
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class calculator extends Applet implements ActionListener,ItemListener
{
	int ans;
	String ac;
	TextField n1,n2;
	Checkbox addi,sub,mul,div;
	CheckboxGroup	cal;
	Button calc;
	Label an;
	public void init()
	{
		Label no1=new Label("Number 1");
		Label no2=new Label("Number 2");
		an=new Label("Answer");
		n1=new TextField(5);
		n2=new TextField(5);
		cal=new CheckboxGroup();
		addi=new Checkbox("Add",cal,false);
		sub=new Checkbox("Sub",cal,false);
		mul=new Checkbox("Mul",cal,false);
		div=new Checkbox("Div",cal,false);
		calc=new Button("Calc");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(no1);
		add(n1);
		add(no2);
		add(n2);
		add(addi);
		add(sub);
		add(mul);
		add(div);
		add(calc);
		add(an);
		addi.addItemListener(this);
		sub.addItemListener(this);
		div.addItemListener(this);
		mul.addItemListener(this);
		calc.addActionListener(this);
	}
	public void itemStateChanged(ItemEvent ie)
	{
		ac=cal.getSelectedCheckbox().getLabel();
		repaint();
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str=ae.getActionCommand();
		ac=cal.getSelectedCheckbox().getLabel();
		if(str.equals("Calc"))
		{
			if(ac.equals("Add"))
			{
			ans=Integer.parseInt(n1.getText())+Integer.parseInt(n2.getText());
			}
			else if(ac.equals("Sub"))
			{
				ans=Integer.parseInt(n1.getText())-Integer.parseInt(n2.getText());
			}
			else if(ac.equals("Mul"))
			{
				ans=Integer.parseInt(n1.getText())*Integer.parseInt(n2.getText());
			}
			else if(ac.equals("Div"))
			{
				ans=Integer.parseInt(n1.getText())/Integer.parseInt(n2.getText());
			}
		}
		repaint();
	}
	public void paint(Graphics g)
	{
		String msg=" "+ans;
		an.setText(msg);
		
	}
}
		