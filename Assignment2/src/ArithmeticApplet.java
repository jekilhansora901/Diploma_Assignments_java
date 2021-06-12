import java.applet.*;
//import java.awt.event.ActionEvent;
import java.awt.*;
//import java.awt.event.ActionListener;
import java.awt.event.*;
public class ArithmeticApplet extends Applet implements ActionListener{

Label l1,l2,l3;
TextField tf1,tf2,tf3;
Button b1,b2,b3,b4;

public void init(){
//setBackground(Color.black);

l1=new Label("No1:");
l2=new Label("No2:");
l3=new Label("Result");

tf1=new TextField(5);
tf2=new TextField(5);
tf3=new TextField(5);

b1=new Button("+");
b2=new Button("-");
b3=new Button("*");
b4=new Button("/");

add(l1);
add(tf1);
add(l2);
add(tf2);
add(b1);
add(b2);
add(b3);
add(b4);
add(l3);
add(tf3);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
}
public void actionPerformed(ActionEvent ae){

int n1=Integer.parseInt(tf1.getText());
int n2=Integer.parseInt(tf2.getText());

if(ae.getSource()==b1){
String s = tf2.getText();
tf3.setText(String.valueOf(s));
}
else if(ae.getSource()==b2){
int diff=n1-n2;
tf3.setText(String.valueOf(diff));
}
else if(ae.getSource()==b3){
int prod=n1*n2;
tf3.setText(String.valueOf(prod));
}
else{
int quo=n1/n2;
tf3.setText(String.valueOf(quo));
}
}

}