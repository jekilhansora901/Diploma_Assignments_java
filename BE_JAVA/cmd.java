class cmd
{
	public static void main(String []s)
	{
		int c,i;
		for(i=0,c=0;i<s.length;i++)
		{
			try
			{
			if(Integer.parseInt(s[i])<0)throw new InterruptedException();
			c++;
			}
			catch(InterruptedException e)
			{
				System.out.println("No. is Negative : "+Integer.parseInt(s[i]));
			}
		}
		System.out.println("Positive No. : "+c);
	}
}