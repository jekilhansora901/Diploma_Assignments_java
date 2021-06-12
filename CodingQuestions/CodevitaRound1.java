import java.util.*;

public class CodevitaRound1 
{
    static int n;
    static int totalTime=0;
    static int ti,t2;
    static  int outWater(int i,int t[],int tub[][],int time)throws Exception 
    {
        ti=time;
        
        int w=t[i];
        w=w-tub[i][2];
        t[i]=w;
        
        ti++;
        
        if(t[i]>=t[i+1])
        {
            
            t[i+1]=t[i+1]+tub[i+1][1];
        
            outWater(i,t,tub,ti);
        }
        
        return ti;
        
    }
    
    static int addWater(int i,int t[],int tub[][],int time,int f)throws Exception 
    {
       
        
        int trav=0;
        t2=time;
        while(trav<=time&&f==0&&time>0)
        {
            t[i]=t[i]+tub[i][1];
         
            trav++;
        }
        if(f==1)
        {
            
          t[i]=t[i]+tub[i][1];
            //time++;
          t2++;
          
        }
        if(t[i]<=t[i-1])
        {
            t2=addWater(i,t,tub,t2,1);
        }
        //return time;
        return t2;
    }
    static int arrangeTub(int t[],int tub[][],int dur)throws Exception
    {
        for(int i=0;i<n;i++)
        {
            if(i<=n-2)
            {
                
                if(t[i]<t[i+1])
                {
                    i++;
                }
                else if(t[i]>=t[i+1])
                {
                    
                    dur=outWater(i,t,tub,dur);
                   
                    i++;
                    
                }
                
            }
            if(i==n-1)
            {
                
                if(t[i]<=t[i-1])
                {
                  
                    dur=addWater(i,t,tub,dur,0);
                    
                }
                
            }
            
            
        }
        
        return dur;
        
    }
    public static void main(String[] args) 
    {
        try
        {
        Scanner sc=new Scanner(System.in);
        
        
        n=sc.nextInt();
        
        int tub[][]=new int[n][n];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                tub[i][j]=sc.nextInt();
            }
        }
        
        
        int t[]=new int[n];
        for(int i=0;i<n;i++)
        {
            t[i]=tub[i][0];
            
        }
        totalTime=arrangeTub(t,tub,0);
        System.out.println(totalTime);
        
         
    }
    catch(Exception e)
    {
        
    }
    }
    
}
