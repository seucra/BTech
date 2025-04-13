#include<stdio.h>

/*********************************************
--------------EUCLID's Algorithm--------------
	WAP to find GCD (greatest common divisor)
	using recursive function 
		z=x%y
*********************************************/

int euclid(int x, int y){
	int z;
	if (y==0)		return x;
	z = x%y;
	x = y;
	y = z;
	if (y!=0)		x = euclid(x,y);
	return x;
}

int main(){
	int  x, y;
	printf("Enter no1 : ");
	scanf("%d", &x);
	printf("Enter no2 : ");
	scanf("%d", &y);
//	if (x< y){
//		t = x;
//		x=y;
//		y=t;
//	} 
	printf("GCD of %d and %d is ::: %d" ,x ,y ,euclid(x,y));
	return 0;
}


