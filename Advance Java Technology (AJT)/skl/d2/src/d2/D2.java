public class D2 {
    public static void main(String[] s) {
        int p=0,ne=0,i,n;
        for(i=0;i<s.length;i++)
        {
            try
            {
            n=Integer.parseInt(s[i]);
            if(n>=0)
            {
                p++;
            }
            else
            {
                ne++;
            }
            } 
            catch(NumberFormatException nfe)
            {
                System.out.println("exception" + nfe);
            }
            
        }
        System.out.println("no of negative numbers are :"+ne);
        System.out.println("no of positive numbers are :"+p);
        //System.out.println("sum="+sum);
    }
    
}
