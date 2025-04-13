#include<stdio.h>

/***
fact
***/

int fac(int n, int f)
{
	if (n==1)	return f;
	return fac(n-1, f*n);
}

int main()
{
	int n, f=1;
	printf("Enter NUmber :: ");
	scanf("%d", &n);
	f = fac(n, f);
	printf("Factorial of %d :: %d\n", n, f);
}
