package assignment2;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class findmax extends Applet implements ActionListener{
    Label l1,l2,l3,l4;
    TextField t1,t2,t3,t4;
    Button b1;
    public void init()
    {
        l1=new Label("No. 1 : ");
        l2=new Label("No. 2 : ");
        l3=new Label("No. 3 : ");
        l4=new Label("Maximum No. : ");
        t1=new TextField(10);
        t2=new TextField(10);
        t3=new TextField(10);
        t4=new TextField(10);
        b1=new Button("\nMaximum");
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(l4);
        add(t4);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){

        int n1=Integer.parseInt(t1.getText());
        int n2=Integer.parseInt(t2.getText());
        int n3=Integer.parseInt(t3.getText());
        if(ae.getSource()==b1)
        {
            if(n1 > n2)
            {
                if(n1 > n3)
                {
                    t4.setText(String.valueOf(n1));
                }
                else
                {
                    t4.setText(String.valueOf(n3));
                }
            }
            else
            {
                if(n2 > n3)
                {
                    t4.setText(String.valueOf(n2));
                }
                else
                {
                    t4.setText(String.valueOf(n3));
                }
            }
        }
}
}