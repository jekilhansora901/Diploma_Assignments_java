/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
 class cast
 {
     public static void main(String args[])
     {
         float sum;
         int i;
         sum = 0.0f;
         for(i=1;i<=10;i++)
         {
             sum = sum + 1/(float)i;
             System.out.println("i="+i);
             System.out.println("sum="+sum);
         }
     }
}
