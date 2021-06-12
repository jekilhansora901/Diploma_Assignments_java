/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
class test 
{
    public static void main(String arg[])
    {
        int i,c,c1,c2;
        float[] weight = {45.0f,55.0f };
        float[] height = {175.5f,164.f};
        c = 0;
        c1=0;
        c2=0;
        for(i=0;i<=4;i++)
        {
            if(weight[i] < 50.0 && height[i] > 170.0)
            {
                c1 = c1 + 1;
            }
            c = c + 1;
        }
   c2 = c - c1;
   System.out.println("no. of persions with.....");
   System.out.println("h"+c1);
   System.out.println("i"+c2);
   

        
    }
    
}
