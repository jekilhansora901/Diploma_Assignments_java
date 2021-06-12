/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
class def 
{
    
    int length;
    int breadth;
    def()
    {
        length = 0;
        breadth = 0;
    }
    def(int x,int y)
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
class def1
{
    public static void main(String args[])
    {
        def d1 = new def();
        def d2 = new def(10,10);
        d1.cal_def();
        d2.cal_def();
    }
}