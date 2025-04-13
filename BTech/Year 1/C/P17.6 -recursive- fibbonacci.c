#include<stdio.h>

/*********************************************

		Fibbonacci - Recursive Function
	
*********************************************/

int fibbo(int k){
	if (k==1 || k==2) return 1;
	return (fibbo(k-1) + fibbo(k-2));
}

int main(){
	int  x;
	printf("Enter no1 : ");
	scanf("%d", &x);
	for (int i = 1 ;i<=x ;i++)		printf("Fibbo %d :: %d\n",i , fibbo(i));
	return 0;
}


