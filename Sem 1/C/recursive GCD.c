#include<stdio.h>

/***
GCD
***/

int GCD(int a, int b)
{
	if (b==0)
		return	a;
	GCD(b, a%b);
}

int main()
{
	int a,b,gcd;
	printf("Enter 2 numbers a,b for GCD\t:: ");
	scanf("%d%d", &a, &b);
	gcd = GCD(a, b);
	printf("GCD of %d, %d\t\t\t:: %d\n", a, b, gcd);
}
