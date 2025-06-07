#include<stdio.h>

/*
	factorial using recursive funtion calling
*/

long fac(long f, int n){
	if (n==1 || n==0)	return f;
	f *= n;
	return fac(f, n-1);
}

void main(){
	int n;
	long f =1;
	printf("Enter N :: ");
	scanf("%d", &n);
	printf("Factorial of %d is ::: %ld", n, fac(f ,n));
	
}

