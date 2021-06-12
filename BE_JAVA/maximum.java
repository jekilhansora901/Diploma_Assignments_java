
class maximum
{
	public static void main(String []s)
	{
		int no1,no2,no3,max;
		no1=Integer.parseInt(s[0]);
		no2=Integer.parseInt(s[1]);
		no3=Integer.parseInt(s[2]);
		if(no1>no2)
		{
			if(no1>no3)
			{
				max=no1;
			}
			else
			{
				max=no3;
			}
		}
		else
		{
			if(no2>no3)
			{
				max=no2;
			}
			else
			{
				max=no3;
			}
		}
		System.out.println("No. : "+no1+"  "+no2+"  "+no3);
		System.out.print("Maximum No. : "+max);
	}
}