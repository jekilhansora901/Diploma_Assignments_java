import java.util.*;
class stack
{
	int s[]=new int [5];
	int top;
	stack()
	{
		top=-1;
	}
	void push(int d_d)
	{
		if(top>3)
		{
			System.out.println("Stack is Overflow");
		}
		else
		{
			top++;
			s[top]=d_d;
			System.out.println("Data Inserted.."+s[top]);
		}
	}
	int pop()
	{
		if(top<0)
		{
			System.out.println("Stack is Underflow");
			return -1;
		}
		else
		{
			int d;
			d=s[top];
			top--;
			return d;
		}
	}
}
class stack_args
{
	public static void main(String [] arg)
	{
		stack st=new stack();
		for(int i=0;i<arg.length;)
		{
			if("push".equals(arg[i]))
			{
				i++;
				st.push(Integer.parseInt(arg[i]));
				i++;
			}
			else if("pop".equals(arg[i]))
			{
				int d=st.pop();
				i++;
				if(d==-1)
					continue;
				System.out.println("Data is Removed : "+d);
				continue;
			}
		}
	}
}