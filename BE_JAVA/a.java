import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class a extends Frame implements ActionListener
{
  	int tmp,y,temp;
    Stack ss;
	JFrame f2;
	JTextField t1,t2;
	JLabel ov=new JLabel();
	JLabel uf,lt;
	
	a()
	{
	temp=401;
	y=400; 
	ss=new Stack();
	tmp=0;

	
//................................................................................................................................
	f2=new JFrame("Stack Operation"); 	
	f2.setVisible(true);
	f2.setLayout(null);
	f2.setSize(400,400);
 	f2.setLocation(500,150);
	f2.setResizable(true);
	lt=new JLabel("Write any text in textbox...");
                   Font font2=new Font("Times New Roman",Font.BOLD,15);
	lt.setFont(font2);
  	lt.setBounds(50,90,300,30);
                    f2.add(lt);

	JLabel sl1=new JLabel("Stack operation");
                   Font sfont1=new Font("Times New Roman",Font.BOLD,20);
	sl1.setFont(sfont1);
  	sl1.setBounds(120,10,300,30);
                    f2.add(sl1);
 
 	t1=new JTextField();
                   t1.setBounds(50,120,100,30);
	f2.add(t1);
   
    JButton b3=new JButton("PUSH");
	b3.setBounds(50,50,100,30);
	f2.add(b3);
	b3.addActionListener(this);

	JButton b4=new JButton("POP");
	b4.setBounds(230,50,100,30);
	f2.add(b4);
	b4.addActionListener(this);
	
	ov.setText("");
	Font font=new Font("Times New Roman",Font.BOLD,18);
	ov.setFont(font);
	ov.setBounds(220,100,130,150);
	f2.add(ov);
	f2.setVisible(true);
	f2.setLayout(null);
	f2.setSize(400,400);
 	f2.setLocation(500,150);
	f2.setResizable(true);

}
	public void actionPerformed(ActionEvent e)
	{
	String str=e.getActionCommand();
	if(str.equals("PUSH"))
	{
		if(tmp>4)
		{
			ov.setText("Stack Overflow");
			t1.setText("");
		}
		else
		{
			if(("").equals(t1.getText()))
			{ 
			JOptionPane.showMessageDialog(this,"Textbox is empty...");
			}
			else
			{
			ss.push(new String(t1.getText()));
			t1.setText("");
			lt.setText("Item Pushed..");
			tmp++;
			}
		}
			if(temp%2==0)
				temp--;
			else
			temp++;
			f2.setSize(temp,400);	
			uf.setText("");	
	}
	else if(str.equals("POP"))
	{ 
		if(tmp<=0)
		{
			ov.setText("Stack Underflow");
			t1.setText("");
		}
		else
		{
		String spop=(String) ss.pop();
		tmp--;
		lt.setText("Item Poped..");
		t1.setText(""+spop);
		}
		if(temp%2==0)
		temp--;
		else
		temp++;
		f2.setSize(temp,400);	
	}
	ov.setText("");
	repaint();
}		
	public void paint()
	{
	}
	public static void main(String args[])
	{
		a d=new a();
	}
}
