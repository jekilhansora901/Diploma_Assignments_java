package complex_m;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class complex 
{
    int i,r;
    complex()
    {
        i=0;
        r=0;
        System.out.println("default constructor");
    }
    complex(int r1,int i1)
    {
        System.out.println("overloaded constructor");
        r=r1;
        i=i1;
    }
    complex add(complex d)
    {
        complex result=new complex();
        result.r=this.r + d.r;
        result.i=this.i + d.i;
        return(result);
    }
    void display()
    {
        System.out.println("r =" + r);
        System.out.println("i =" + i);
    }
    
}
