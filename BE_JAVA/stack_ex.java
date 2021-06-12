class stack
{
	public int s[]=new int[10];
	public int top;
	
	stack()
	{
		top=-1;
	}
	void push(int d)
	{
		if(top>9)
		{
			System.out.println("Stack Overflow..");
		}
		else
		{
			top=top+1;
			s[top]=d;
			System.out.println("Data Inserted..");
		}
	}
	int pop()
	{
		int d;
		if(top<0)
		{
			System.out.println("Stack Underflow..");
			return -1;
		}
		else
		{
			d=s[top];
			top=top-1;
			System.out.println("Data Removed..");
			return d;
		}
	}
	public static void main(String []s)
	{
		stack st=new stack();
		int i=0,j;
		for(i=0;i<s.length;i++)
		{
			if(Integer.parseInt(s[0])==11)
			{
			
				for(j=i+1;j<s.length;j++)
				{
					if(Integer.parseInt(s[0])==111)
					{
						continue;
					}
					else
					{
						int a=Integer.parseInt(s[j]);
						st.push(a);
					}
				}
			}
			else if(Integer.parseInt(s[0])==111)
			{
				for(j=i+1;j<s.length;j++)
				{
					if(s[i]=="-")
					{
						System.out.println("Data Removed : "+st.pop());
					}
				}
			}
		}
	}
}
		