/*<applet code="cal" height=300 width=200>
</applet>
*/
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class cal extends Applet implements ActionListener
{
	String no1,no2,kno1,kno2,st;
	int in1,in2,ans;
	char opp;
	Panel osCards,nooo;
	Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,np,oa,os,om,od,clear;
	TextField no;
	public void init()
	{
		no1="";
		st="";
		setLayout(new BorderLayout());
		Panel IN=new Panel();
		no=new TextField(20);
		IN.add(no);
		add(IN,BorderLayout.NORTH);
		n1=new Button("1");
		n2=new Button("2");
		n3=new Button("3");
		n4=new Button("4");
		n5=new Button("5");
		n6=new Button("6");
		n7=new Button("7");
		n8=new Button("8");
		n9=new Button("9");
		n0=new Button("0");
		np=new Button("=");
		clear=new Button("Clear");
		Panel numm=new Panel();
		numm.setLayout(new GridLayout(4,3));
		numm.add(n7);
		numm.add(n8);
		numm.add(n9);
		numm.add(n4);
		numm.add(n5);
		numm.add(n6);
		numm.add(n1);
		numm.add(n2);
		numm.add(n3);	
		numm.add(clear);
		numm.add(n0);
		numm.add(np);
		add(numm,BorderLayout.CENTER);
		Panel Op=new Panel();
		Op.setLayout(new GridLayout(1,4));
		oa=new Button("+");
		os=new Button("-");
		om=new Button("*");
		od=new Button("/");
		Op.add(oa);
		Op.add(os);
		Op.add(om);
		Op.add(od);
		add(Op,BorderLayout.SOUTH);
		n1.addActionListener(this);
		n2.addActionListener(this);
		n3.addActionListener(this);
		n4.addActionListener(this);
		n5.addActionListener(this);
		n6.addActionListener(this);
		n7.addActionListener(this);
		n8.addActionListener(this);
		n9.addActionListener(this);
		n0.addActionListener(this);
		np.addActionListener(this);
		oa.addActionListener(this);
		os.addActionListener(this);
		od.addActionListener(this);
		om.addActionListener(this);
		clear.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String btn=ae.getActionCommand();
		if(btn.equals("1"))
		{
			no1+="1";
			no.setText(no1);
			st+="1";
			showStatus(st);
		}
		else if(btn.equals("2"))
		{
			no1+="2";
			no.setText(no1);
			st+="2";
			showStatus(st);
		}
		else if(btn.equals("3"))
		{
			no1+="3";
			no.setText(no1);
			st+="3";
			showStatus(st);
		}
		else if(btn.equals("4"))
		{
			no1+="4";
			no.setText(no1);
			st+="4";
			showStatus(st);
		}
		else if(btn.equals("5"))
		{
			no1+="5";
			no.setText(no1);
			st+="5";
			showStatus(st);
		}
		else if(btn.equals("6"))
		{
			no1+="6";
			no.setText(no1);
			st+="6";
			showStatus(st);
		}
		else if(btn.equals("7"))
		{
			no1+="7";
			no.setText(no1);
			st+="7";
			showStatus(st);
		}
		else if(btn.equals("8"))
		{
			no1+="8";
			no.setText(no1);
			st+="8";
			showStatus(st);
		}
		else if(btn.equals("9"))
		{
			no1+="9";
			no.setText(no1);
			st+="9";
			showStatus(st);
		}
		else if(btn.equals("0"))
		{
			no1+="0";
			no.setText(no1);
			st+="0";
			showStatus(st);
		}
		else if(btn.equals("+"))
		{
			in1=Integer.parseInt(no.getText());
			no1="";
			no.setText("");
			opp='+';
			st+=opp;
			showStatus(st);
		}
		else if(btn.equals("-"))
		{
			in1=Integer.parseInt(no.getText());
			no1="";
			no.setText("");
			opp='-';
			st+=opp;
			showStatus(st);

			}
		else if(btn.equals("*"))
		{
			in1=Integer.parseInt(no.getText());
			no1="";
			no.setText("");
			opp='*';
			st+=opp;
			showStatus(st);

			}
		else if(btn.equals("/"))
		{
			in1=Integer.parseInt(no.getText());
			no1="";
			no.setText("");
			opp='/';
			st+=opp;
			showStatus(st);
		}
		else if(btn.equals("="))
		{
			in2=Integer.parseInt(no.getText());
			switch(opp)
			{
				case '+':ans=in1+in2;
						 no2=""+ans;
						 break;
				case '-':ans=in1-in2;
						 no2=""+ans;
						 break;
				case '*':ans=in1*in2;
						 no2=""+ans;
						 break;
				case '/':ans=in1/in2;
						 no2=""+ans;
						 break;
			}	
			no.setText(no2);
			st+="="+no2;
			showStatus(st);
			st="";
			no1="";
			no2="";
			ans=0;
			in1=0;
			in2=0;
		}
		else if(btn.equals("Clear"))
		{
			no1="";
			no2="";
			ans=0;
			in1=0;
			in2=0;
			no.setText(no1);
			showStatus("Cleared..");
		}
		repaint();
	}
	public void paint(Graphics g)
	{
	}
}