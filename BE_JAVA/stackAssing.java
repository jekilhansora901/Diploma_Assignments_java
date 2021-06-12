import java.util.*;
class stackAssing
{
	int top;
	int max=5;
	int data[]=new int[5];
	stackAssing()
	{
		top=-1;
	}
	void push()
	{
		if(top>3)
		{
			System.out.println("Stack Overflow..");
		}
		else
		{
			top++;
			Scanner s=new Scanner(System.in);
			System.out.println("Enter Data : ");
			data[top]=s.nextInt();
			System.out.println("Data is Inserted..");
		}
	}
	void pop()
	{
		if(top<0)
		{
			System.out.println("Stack Underflow..");
		}
		else
		{
			System.out.println("Data is Removed : "+data[top--]);
		}
	}
	public static void main(String s[])
	{
		stackAssing st=new stackAssing();
		st.push();
		st.push();
		st.push();
		st.push();
		st.push();
		st.push();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
	}
}
		
		