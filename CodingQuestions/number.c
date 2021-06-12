#include <stdio.h>
#include <ctype.h>
#define hn(i) (i*(2*i-1))
#define tn(i) (i*(i+1))/2
int main()
{
	int t1,t2,m,c;
	int i;
	scanf("%d %d %d",&t1,&t2,&m);
	if(t1<0 || t2<0 || m<0 || t1>t2)
	{
		printf("Invalid input");
		return 0;
	}
	else
	{
	for(i=1,c=0;i<=t2;i++)
	{
		if(hn(i)>=tn(i))
		{
			if(hn(i)>=t1 && hn(i)<=t2)
			{
				c++;
				if(c==m)
				{
					printf("%d",hn(i));
					return 0;
				}
			}
		}
	}
	if(c!=m)
	{
		printf("No Number is present at this index");
	}
	return  0;
	}
}