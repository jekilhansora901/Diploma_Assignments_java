//Online shopping form
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyForm extends JApplet implements ActionListener
{
	//vars
	String str="", str1="", str2="";
	Object x[];
	JLabel n,a,i,lbl;
	JTextField name;
	JTextArea addr;
	JList lst;
	JButton b1,b2;
	Container c;
	public void init()
	{
		//create JFrame and container 
		JFrame jf = new JFrame();
		c = jf.getContentPane();
		//display yellow background color in container
		c.setBackground(Color.yellow);
		//do not set any layout to c
		c.setLayout(null);
		//set the size and title for frame 
		jf.setSize(500,400);
		jf.setTitle("My Form");
		//display the frame
		jf.setVisible(true);
		//Display heading in the frame using a label
		Font f = new Font("Dialog",Font.BOLD,26);
		lbl = new JLabel();
		lbl.setFont(f);
		lbl.setForeground(Color.red);
		lbl.setText("Z-ELECTRONICS ONLINE SHOP");
		lbl.setBounds(200,10,500,50);
		c.add(lbl);
		//TextField and a label for entering name
		n = new JLabel("Name: ", JLabel.LEFT);
		name = new JTextField(30);
		n.setBounds(50,100,100,30);
		name.setBounds(200,100,200,30);
		c.add(n);
		c.add(name);
		//TextArea and a label for entering address
		a = new JLabel("Address: ", JLabel.LEFT);
		addr = new JTextArea(5,50);
		a.setBounds(50,150,100,30);
		addr.setBounds(200,150,200,100);
		c.add(a);
		c.add(addr);
//List box for multiple selection
		i = new JLabel("Select items: ", JLabel.LEFT);
String[] data = {"TVs", "Washing machines", "DVD players", 
		"Refrigerators"};
		lst = new JList(data);
		i.setBounds(50,270,100,30);
		lst.setBounds(200,270,200,100);
		c.add(i);	
		c.add(lst);
//add Two push buttons: OK and Cancel
		b1 = new JButton("OK");
		b2 = new JButton("Cancel");
		b1.setBounds(200,400,100,30);
		b2.setBounds(350,400,100,30);
		c.add(b1);
		c.add(b2);
		//add listeners to buttons 
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	//this method is executed when the buttons are clicked
	public void actionPerformed(ActionEvent ae)
	{
		//know which button is clicked 
		str = ae.getActionCommand();
		//if the button label is OK then
		if(str.equals("OK")) 
		{
			//retrieve data from text field, text area and list boxes
			str1= name.getText()+"\n";
			str1+= addr.getText()+"\n";
			x = lst.getSelectedValues();    
			for(int i=0;i<x.length; i++) 
str2 +=(String)x[i]+"\n";     
			//display the data in text area
			addr.setText(str1+str2);

			//make the strings empty
			str1="";

   str2="";
		}
		else{

			//if Cancel button is clicked, clear the data in the form
			name.setText("");
			addr.setText("");
			lst.clearSelection();
		}
	} 
}
