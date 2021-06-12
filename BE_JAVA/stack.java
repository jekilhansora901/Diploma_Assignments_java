class stack
{
	public int s[]=new int[5];
	public int top;
	
	stack()
	{
		top=-1;
	}
	void push(int d)
	{
		/*if(top>9)
		{
			System.out.println("Stack Overflow..");
		}
		else
		{*/
			try
			{
			if(top>4) throw new ArrayIndexOutOfBoundsException();
			top=top+1;
			s[top]=d;
			System.out.println("Data Inserted.."+s[top]);
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Error: Stack Overflow.."+e);
			}
	}
	void pop()
	{
		try
		{
			int d;
			if(top<0) throw new InterruptedException();
			d=s[top];
			top=top-1;
			System.out.println("Data Removed.."+d);
		}
		catch(InterruptedException e)
		{
			System.out.println("Stack Underflow..");
		}
	}
	public static void main(String []s)
	{
		stack st=new stack();
		st.pop();
		st.push(1);
		st.pop();
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		st.push(7);
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		
	}
}