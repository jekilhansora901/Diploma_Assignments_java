/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahooFormInf;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author student
 */
public class YahooFormInf JFrame implements ActionListner {

    JTextField firstName;
    JTextField lastName;
    JTextField userName;
    JTextField password;
    JRadioButton genderMale;
    JRadioButton genderFemale;
    JButton createAccount;
    JButton reset;
    JButton previous;
    JButton next;
    ButtonGroup gender;
    Container thisform;
    
    public YahooFormInf() throws HeadlessException
    {
        thisForm=this.getContentPane();
        thisForm.setLayout (new GridLayout(8,4,10,10));
        firstName=new JTextField("Enter your first name",50);
        lastName=new JTextField("Enter your last name",50);
        userName=new JTextField("Enter your user name",50);
        password=new JTextField("Enter your password",50);
        createAccount=new JButton("create Account");
        reset=new JButton("Reset");
        previous=new JButton("Previous");
        next=new JButton("Next");
        gender=new ButtonGroup();
        genderMale=new JRadioButton("Male");
        genderFemale=new JRadioButton("Female");
        gender.add(genderMale);
        gender.add(genderFemale);
        
        thisForm.add(firstName);
        thisForm.add(lastName);
        thisForm.add(userName);
        thisForm.add(password);
        thisForm.add(genderMale);
        thisForm.add(genderFemale);
        thisForm.add(previous);
        thisForm.add(createAccount);
        thisForm.add(reset);
        thisForm.add(next);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
        
    }
    
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public static void main(String[] args)
{

    YahooFormInf lf=new YahooFormInf();
    lf.setSize(2000,2000);
    lf.setTitle("Yahoo!");
    lf.setVisible(true);
}
        // TODO start asynchronous download of heavy resources
    }

    // TODO overwrite start(), stop() and destroy() methods
}
