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
class stack_main
{
	public static void main(String [] arg)
	{
		stack st=new stack();
		Scanner sc=new Scanner(System.in);
		int ch,con;
		do
		{
		System.out.println("1. Push");
		System.out.println("2. Pop");
		System.out.println("3. Exit");
		System.out.println("Enter Your Choice : ");
		ch=sc.nextInt();
		switch(ch)
		{
			case 1 :System.out.println("Enter Data : ");  
					st.push(sc.nextInt());
					break;
			case 2 :int d=st.pop();
					if(d==-1)
						break;
					System.out.println("Data is Removed : "+d);
					break;
			case 3 :System.exit(0);
		}
		System.out.println("Do you want to continue : ? (1 / 0 ) : ");
		con=sc.nextInt();
		}while(con==1);
	}
}