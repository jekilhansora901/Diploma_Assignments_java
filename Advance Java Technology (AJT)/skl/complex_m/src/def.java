/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
class pera
{
    
    int length;
    int breadth;
    pera()
    {
        length = 0;
        breadth = 0;
    }
    pera(int x,int y)
    {
        length = x;
        breadth = y;
        
    }
    void cal_def()
    {
        int peri;
        peri = 2*(length+breadth);
        System.out.println("perameter is"+peri);
        
    }

    
}
class c_pera
{
    public static void main(String args[])
    {
        pera d1 = new pera();
        pera d2 = new pera(10,10);
        d1.cal_def();
        d2.cal_def();
    }
}