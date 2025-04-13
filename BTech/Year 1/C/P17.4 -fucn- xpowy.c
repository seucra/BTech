#include<stdio.h>

/*
	factorial using recursive funtion calling
*/

long pwr(int x, int y,long res){
	if (y==0)		return res;
	
	res *= x;
	return pwr(x, y-1, res);
}

void main(){
	int x, y;
	long r=1;
	printf("Enter x, y :: ");
	scanf("%d%d", &x, &y);
	printf("%d^%d is ::: %ld",x ,y ,pwr(x, y, r));
	
}

