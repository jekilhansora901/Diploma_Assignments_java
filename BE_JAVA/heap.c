#include<stdio.h>

#include<math.h>

int parent(int i)
{
	if(i%2==0)
	{
		return (i/2);
	}
	else
	{
		i=i-1;
		return (i/2);
	}

}

int left(int i)
{

	return 2*i;

}

int right(int i)
{

	return (2*i)+1;

}

void heapify(int a[],int i,int n)

{

	int l,r,largest;

	l=left(i);

	r=right(i);

	if(l<=n && a[l]>a[i])
		largest=l;
	else
		largest=i;
	if(r<=n && a[r]>a[largest])
		largest=r;

	if(largest!=i)
	{
		int temp=a[i];
		a[i]=a[largest];
		a[largest]=a[i];
		heapify(a,largest,n);
	}
}

void build_heap(int a[],int n)
{
	int i,c;
	if(n%2==0)
	{
		i=n/2;
	}
	else
	{
		c=n-1;
		i=c/2;
	}
	for(;i>=0;i--)
	{
		heapify(a,i,n);
	}
}

void heapsort(int a[],int n)
{
	int i;
	build_heap(a,n);

	for(i=n;i>0;i=i-2)
	{
		int temp=a[1];
		a[1]=a[i];
		a[i]=temp;
		n=n-1;
		heapify(a,1,n);
	}
}
int main()
{
	int a[5]={5,2,7,1,9};
	int i,n=5;
	printf("Data : ");
	for(i=0;i<5;i++)
		printf(" %d ",a[i]);	
	build_heap(a,n);
	printf("\nHeap : ");
	for(i=0;i<5;i++)
		printf(" %d ",a[i]);
	heapsort(a,n);
	printf("\nsorted : ");
	for(i=0;i<5;i++)
		printf(" %d ",a[i]);
	return 0;
}