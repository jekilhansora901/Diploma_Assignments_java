/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class ca
{
int i,j,k;
    ca()
    {
        i=0;
        j=0;
        k=0;
        System.out.println("default constructor");
    }
    ca(int i1,int j1,int k1)
    {
        System.out.println("overloaded constructor");
        i=i1;
        j=j1;
        k=k1;
    }
    ca add(ca d)
    {
        ca result=new ca();
        result.j=this.j + d.j;
        result.i=this.i + d.i;
        
        result.k=this.k + d.k;
        return(result);
    }
    void display()
    {
        
        System.out.println("i =" + i);
        System.out.println("j =" + j);
        System.out.println("k =" + k); 
    }   
    
}
