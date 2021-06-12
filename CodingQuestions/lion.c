#include<stdio.h>
int main()
{
	int pivot,i,a[8],j,k,high,low,m,l,temp;
	printf("Enter 8 element");
	for(i=0;i<8;i++)
	{
		scanf("%d\n",&a[i]);
	}
	pivot=0;
for(k=0;k<8;k++)
{	
	for(j=pivot;j<8;j++)
	{
		if(a[j]<pivot)
		{
			low=j;
			break;
		}
	}
	for(l=7;l<=pivot;l--)
	{
		if(a[l]>pivot)
		{
			high=l;
			break;
		}
	}
	if(l<j)
	{
		temp=a[pivot];
		a[pivot]=a[high];
		a[high]=a[pivot];
		pivot=pivot+1;
	}
	else
	{
		temp=a[high];
		a[high]=a[low];
		a[low]=a[high];
	}
}
printf("Sorting is");
for(m=0;m<7;m++)
scanf("%d\n",a[m]);
return 0;	
}
