#include<stdio.h>

/*
	sum first n using recursive
*/

int sm(int s, int n){
	if (n==0)		return s;
	s += n;
	return sm(s, n-1);
}


void main(){
	int n, s=0;
	printf("Enter n:: ");
	scanf("%d", &n);
	printf("sum first %d natural no is ::: %d",n ,sm(s, n));	
}

