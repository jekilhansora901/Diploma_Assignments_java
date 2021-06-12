import java.util.*;
import java.io.*;
public class matrot 
{
       static int n,deg;
       static int[][] matrix;
       static Scanner s=new Scanner(System.in);
       static void get()
       {
            n=s.nextInt();
            if(n<1000 && n>-1)
            {
              int i,j;
              matrix=new int[n][n];
              for (i=0; i<n; i++)
              {
                  for (j=0; j<n; j++)
					matrix[i][j] = s.nextInt();         
              }
            }
        }
        static void rot(int[][] matrix,int deg)
        {
         int layer, first, last, offset, top; 
         while(deg!=0)
         {
          for (layer = 0; layer < n/2 ; layer++) 
          {
             first = layer;
             last = n - layer - 1;
             for (int i=first; i< last ; i++) 
             {
                offset = i - first;
                top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top;
             }
          }
          deg--;
        }
      }  
  public static void main(String[] args) 
  {
       int b=0,y,x,k,c,f=0;
       get();
       String str,str1;         
       do 
       {
         str=s.nextLine();
         StringTokenizer st=new StringTokenizer(str);
         while(st.hasMoreTokens())
         {
            str1=st.nextToken();
            if(str1.equals("A"))
            {
               if((c=Integer.parseInt(st.nextToken()))%90==0 && c<160000 && c>0)
               { 
                  b=c/90;
                  f=f+b;
                  rot(matrix,b);
				  continue; 
               }
            }
			
            x= Integer.parseInt(st.nextToken());
            y= Integer.parseInt(st.nextToken());
            if(str1.equals("Q"))
            {
				if(x>0 && x<=n  && y<=n && y>0)
       			System.out.println(matrix[x-1][y-1]);
		        continue; 
			}
           if(str1.equals("U"))
           {
               if(x>0 && x<=n  && y<=n && y>0)
               {
                  k=4-f;
                  if(k<0)
                  {
                     k=4-(k*(-1));
                  }
                  rot(matrix,k);
                  k=0;
                  matrix[x-1][y-1]=Integer.parseInt(st.nextToken());
                  rot(matrix,f);
              } 
			    continue; 
               
           }
       }
        
     }while(!(str.equals("-1")));
   
   }
}
