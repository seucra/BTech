#include<stdio.h>

/***
reverse
***/

int rev(int n,int r)
{
	if (n==0)	return r;
	rev(n/10, r*10+n%10);
}

int main()
{
    int n, r=0;
    printf("Enter Numbers :: ");
    scanf("%d", &n);
    r = rev(n,r);
    printf("reverse :: %d\n", r);
    return 0;
}

