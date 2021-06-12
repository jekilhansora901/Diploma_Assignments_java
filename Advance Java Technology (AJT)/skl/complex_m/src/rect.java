/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
class rect 
{
    
    int length,width;
    rect(int x,int y)
    {
        length = x;
        width = y;
        
    }
    int rectarea()
    {
        return(length*width);
    }
            
}
class rectarea
{
    public static void main(String args[])
    {
        rect r = new rect(10,10);
        int area1 = r.rectarea();
        System.out.println("area ="+area1);
        
    }
    
}
