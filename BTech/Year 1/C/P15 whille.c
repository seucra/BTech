#include<stdio.h>

int main()
{
	int i =0,c=0;
	printf("Display Table of : ");
	scanf("%d",&i);
	while (i/10)
	{
		printf("%d X %d = %d\n",i,c,i*c);
		c+=1;
	}
}
