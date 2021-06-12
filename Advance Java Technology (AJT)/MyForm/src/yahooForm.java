/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;
class yahooForm extends JFrame implements ActionListener
{
   
    JTextField fname, lname, yusername, mobile, password, recoverno, relation;
    JRadioButton male, female;
    ButtonGroup gender;
    JLabel signup, bdate;
    String[] day={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String [] month={"Jan","Feb","Mar","Apr","May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String[] year={"1990","1991","1992","1993","1994","1995","1996"};
    String [] con={"+91","+92","+1","+3","+6", "+7", "+8", "+90", "+89"};
    
    
    JComboBox<String> jmonth=new JComboBox<String>(month);
    JComboBox<String> jday = new JComboBox<String>(day);
    JComboBox<String> jyear = new JComboBox<String>(year);
    JComboBox<String> jcon = new JComboBox<String>(con);
    JComboBox<String> jcon1 = new JComboBox<String>(con);
    JButton submit;
    Container c;
    JCheckBox cb;
    
    
    yahooForm()
    {
            c = this.getContentPane();
            c.setLayout(null);
            
            Font f = new Font("Dialog",Font.BOLD,23);
            
            signup=new JLabel("SIGN UP", JLabel.LEFT);
            signup.setFont(f);
            signup.setBounds(10,10,200,30);
            
            bdate=new JLabel("Birthdate :",JLabel.LEFT);
            
            fname=new JTextField();
            fname.setText("First Name");
            lname=new JTextField();
            lname.setText("Last Name");
            
            fname.setBounds(10,50,120,20);
            lname.setBounds(140,50,120,20);
            
            yusername=new JTextField();
            yusername.setText("Yahoo User Name");
            
            yusername.setBounds(10,80,250,20);
            
            password=new JTextField();
            password.setText("Password");
            
            password.setBounds(10,110,250,20);
            
            mobile=new JTextField();
            mobile.setText("Enter Mobile Number");
            
            jcon.setBounds(10,140,50,20);
            mobile.setBounds(65,140,160,20);
            
            bdate=new JLabel("Birthdate :",JLabel.LEFT);
            
            bdate.setBounds(10,170,60,20);
            jday.setBounds(70,170,50,20);
            jmonth.setBounds(130,170,60,20);
            jyear.setBounds(200,170,60,20);
            
            
            
            
            recoverno=new JTextField();
            recoverno.setText("Recovery Number");
            relation=new JTextField();
            relation.setText("Relationship");
            
            jcon1.setBounds(10,230,50,20);
            recoverno.setBounds(65,230,105,20);
            relation.setBounds(175,230,85,20);
            
            
            male = new JRadioButton("Male");
            female = new JRadioButton("Female");
            gender = new ButtonGroup();
            gender.add(male);
            gender.add(female);
            
            male.setBounds(10,200,100,20);
            female.setBounds(120,200,100,20);
            
            cb = new JCheckBox("  I Agree to yahoo Terms and Privacy");
            
            cb.setBounds(10,260,250,20);
            
            submit=new JButton("Create Account");
            
            submit.setBounds(10,290,150,30);
            
            c.add(jcon);
            c.add(jcon1);
            c.add(cb);
            c.add(signup);
            c.add(bdate);
            c.add(fname);
            c.add(lname);
            c.add(yusername);
            c.add(password);
            c.add(mobile);
            c.add(recoverno);
            c.add(relation);
            c.add(male);
            c.add(female);
            c.add(submit);
            c.add(jday);
            c.add(jmonth);
            c.add(jyear);
    }
            
            
            
            
  

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public static void main(String args[])
   {
        yahooForm yf = new yahooForm();
        yf.setSize(300,400);
        yf.setTitle("Registration Form");
        yf.setVisible(true);
   }
}
