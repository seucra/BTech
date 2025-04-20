#include<stdio.h>

/***
fibbo
***/

int fibbo(int n)
{
	if (n==0)	return 0;
	if (n==1)	return 1;
	return fibbo(n-1)+fibbo(n-2);
}

int main()
{
	int n, f;
	printf("Enter Term :: ");
	scanf("%d", &n);
	f = fibbo(n);
	printf("Fibbonacci of term %d :: %d\n", n, f);
}
