class stackex
{
	public static int s[]=new int[5];
	public static int top;
	
	stackex()
	{
		top=0;
	}
	void push(int d)
	{
			try
			{
			//if(top>4) throw new InterruptedException();
			s[top]=d;
			top=top+1;
			System.out.println("Data Inserted.."+s[top]);
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Error: Stack Overflow..");
				top--;
			}
			/*catch(InterruptedException e)
			{
				System.out.println("Error: Stack Overflow..");
			}*/
	}
	void pop()
	{
		try
		{
			int d;
			if(top<0) throw new InterruptedException();
			System.out.println("Data At.."+top);
			d=s[top];
			top--;
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
		//
		st.push(2);
		st.pop();
		//System.out.println(" Top "+st.top);
		//System.out.println(" S[top] "+st.s[top]);
		st.push(3);
		//System.out.println(" Top "+st.top);
		//System.out.println(" S[top] "+st.s[top]);
		st.push(4);
		//System.out.println(" Top "+st.top);
		//System.out.println(" S[top] "+st.s[top]);
		//st.pop();
		st.push(5);
		//System.out.println(" Top "+st.top);
		//System.out.println(" S[top] "+st.s[top]);
		st.push(6);
		//st.pop();
		//System.out.println(" Top "+st.top);
		//System.out.println(" S[top] "+st.s[top]);
		st.push(7);
		//System.out.println(" Top "+st.top);
		//System.out.println(" S[top] "+st.s[top]);
		
		st.push(8);
		st.pop();
		st.pop();
		st.pop();
		
		st.pop();
		st.pop();
		st.pop();
		//st.pop();
		//st.pop();
		//st.pop();
		//st.pop();
		//st.pop();
		//st.pop();
		
	}
}