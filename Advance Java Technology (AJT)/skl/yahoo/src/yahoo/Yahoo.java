/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoo;
//Online shopping form
//Changing the look and feel of components

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Yahoo extends JFrame implements ActionListener{
    String str="",str1="",str2="";
    Object x[];
    JLabel fn,ln,ps,lbl;
    JTextField fnm,lnm,pss;
    JButton b1,b2;
    Container c;
    public void init()
    {
        JFrame jf=new JFrame();
       c = jf.getContentPane();
       c.setBackground(Color.white);
       c.setLayout(null);
       jf.setSize(500,400);
       jf.setTitle("yahoo");
       jf.setVisible(true);
       
       Font f = new Font("arial",Font.BOLD,26);
		lbl = new JLabel();
		lbl.setFont(f);
		lbl.setForeground(Color.red);
		lbl.setText("Yahoo !!");
		lbl.setBounds(200,10,500,50);
		c.add(lbl);
                
                fn=new JLabel("first name",JLabel.LEFT);
                ln=new JLabel("last name",JLabel.LEFT); 
                ps=new JLabel("password",JLabel.LEFT) ;
                
                fnm=new JTextField(30);
                lnm=new JTextField(30);
                pss=new JTextField(30); 
                
                fn.setBounds(250,50,100,20);
                fnm.setBounds(250,50,100,20);
                ln.setBounds(250,70,100,20);
                lnm.setBounds(250,70,100,20);
                ps.setBounds(250,90,100,20);
                pss.setBounds(250,90,100,20);
                
                c.add(fn);
                c.add(fnm);
                c.add(ln);
                c.add(lnm);
                c.add(ps);
                c.add(pss);
                
                b1=new JButton("Sign Up");
                b2=new JButton("Reset");
                b1.setBounds(400,110,50,10);
                b2.setBounds(420,110,50,10);
                c.add(b1);
                c.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/**
 *
 * @author student
 */

