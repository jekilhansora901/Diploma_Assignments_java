package complex_m;


import complex_m.complex;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author student
 */
public class Complex_m {

    /**
     * @param args the command line arguments
     */
    
        public static void main(String s[])
    {
        complex c1 = new complex(1,8);
        complex c2 = new complex(3,2);
        complex c3;
        c3=c1.add(c2);
        c3.display();
        // TODO code application logic here
    }
    
}
