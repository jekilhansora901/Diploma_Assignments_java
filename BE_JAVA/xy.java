class xy
{
	public static void main(String s[])
	{
		int x,y,ans;
		x=Integer.parseInt(s[0]);
		y=Integer.parseInt(s[1]);
		try
		{
			if(y<0)throw new NumberFormatException();
			ans=1;
			for(int i=0;i<y;i++)
			{
				ans=ans*x;
			}
			System.out.println("Answer : "+ans);	
		}
		catch(NumberFormatException e)
		{
			System.out.println("You Enter Invalid Number ");
		}
		finally
		{
			System.out.println("Finally Block");
		}
	}
}