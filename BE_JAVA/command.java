class command
{
	public static void main(String []s)
	{
		int a[]=new int[s.length];
		int d=0;
		for(int i=0;i<s.length;i++)
		{
			try
			{
				
				a[d]=Integer.parseInt(s[i]);
				d++;
			}
			catch(NumberFormatException e)
			{
				//System.out.println("Exception");
			}
		}
		int sum=0;
		for(int i=0;i<d;i++)
		{
			sum=sum+a[i];
		}
		sum=sum/d;
		System.out.println("Average : "+sum);
	}
}
		