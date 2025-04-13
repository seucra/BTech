#include<stdio.h>

int cube(int n)
{
	return n*n*n;
}

int sumcube(int n, int sum)
{
	if (n==0)		return sum;
	return sumcube(n/10, sum+cube(n%10));
}

int main()
{
	int n, sum=0;
	printf("enter number:: ");
	scanf("%d", &n);
	sum = sumcube(n,sum);
	printf("sum of cube of number is :: %d\n", sum);
	return 0;
}
