#include<stdio.h>

int main(){
	int x[5], i;
	for ( i=0; i<5; i++){
		printf("Enter number %d :: ", i);
		scanf("%d", &x[i]);
	}
	for (i =0 ;i<5 ; i++){
		printf("Number %d ::: %d\n",i+1, x[i]);
	}
	
} 


