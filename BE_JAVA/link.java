//import java.util.*;
class node
{
	int data;
	node next;
	node()
	{
		next=null;
	}
	node(int d)
	{
		data=d;
		next=null;
	}
	void apend(int data)
	{
		node temp=new node();
		temp.data=data;
		node trav=this;
		while(trav.next!=null)
		{
			trav=trav.next;
		}
		trav.next=temp;
	}
	void traverse()
	{
		node temp=this;
		System.out.println("");
		while(temp!=null)
		{
			System.out.print(" "+temp.data+" -> ");
			temp=temp.next;
		}
	}
}
class link
{
	public static void main(String [] args)
	{
		node start=new node(10);
		start.apend(20);
		start.apend(30);
		start.apend(40);
		start.apend(50);
		start.traverse();
	}
}
		