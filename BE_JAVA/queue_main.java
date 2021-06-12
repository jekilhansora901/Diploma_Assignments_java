class queue
{
	int data[]=new int [5];
	int front,rear;
	queue()
	{
		front=rear=-1;
	}
	void insert(int d)
	{
		if(rear>3)
		{
			System.out.println("Queue is Overflow..");
		}
		else
		{
			rear++;
			
			data[rear]=d;
			if(front==-1)
				front++;
			System.out.println("Data Inserted : "+data[rear]);
		}
	}
	void delete()
	{
		if(front==-1)
		{
			System.out.println("Queue Underflow");
		}
		else
		{
			int item=data[front];
			if(front==rear)
			{
				front=rear=-1;
			}
			else
				front++;
				System.out.println("Data Removed : "+item);
		}
	}
}
class queue_main
{
	public static void main(String [] args)
	{
		queue q=new queue();
		q.delete();
		q.insert(20);
		q.insert(10);
		q.insert(30);
		q.insert(40);
		q.insert(50);
		q.insert(10);
		q.delete();
		q.delete();
		q.delete();
		q.delete();
		q.delete();
		q.delete();
	}
}
				