import java.util.*;
public class com {

    public static void main(String[] args) 
    {
		try 
		{
		int total;
        String req="";
        int flag=0,cnt=1;
        Scanner sc=new Scanner(System.in);
        
        total=sc.nextInt();
        int data[][]=new int[total+1][total+1];
        
        for(int i=0;i<total;i++)
        {
            for(int j=0;j<total;j++)
            {
                data[i][j]=-1;
            }
            
        }
        
       
        
        do
        {
            
            req=sc.next();
            int a,b;
           
             
            int trav=0;
            
            if(req.length()==3&&req.charAt(0)=='C'||req.charAt(0)=='Q')
            {
                a=req.charAt(1)-48;
                b=req.charAt(2)-48;
                if(req.charAt(0)=='Q'&&a<=total&&b<=total)
                {
                    if(a==0&&b==0)
                    {
                        System.out.println(flag);
                    }
                 
                }
                if(req.charAt(0)=='C'&&a<=total&&b<=total)
                {
                    
                    if(a<b)
                    {
                        data[a][b]=1;
                        cnt++;
                        if(cnt%2==0)
                        {
                            
                            flag++;
                        }
                        else
                        {
                            
                            flag--;
                        }
                    }
                    else
                    {
                        data[b][a]=1;
                        cnt++;
                        if(cnt%2==0)
                        {
                            flag++;
                        }
                        else
                        {
                            flag--;
                        }
                    }
                    
                }
                
            }
            
            
            
        }while(!(req.equals("-1")));
    }
	catch(Exception e)
	{
		
	}
    }
}
