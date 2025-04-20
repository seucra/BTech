#include<stdio.h>

/***************************************************************
	clock wise rotation of elements in an array
	
	a100->a99,...a5->a4,a4->a3,...a0->a100 
***************************************************************/

int main(){
	int e, i, temp;
	printf("No. of elements to product :: ");
	scanf("%d", &e);
	int n[e];
	for (i=0; i<e; i++){
		printf("Enter element %d :: ", i+1);
		scanf("%d", &n[i]);
	}
	temp = n[e-1];
	for (i=e-1; i>0; i--){
		n[i] =n[i-1];
	}
	n[0] = temp;
	for (i =0 ;i<e ; i++){
		printf("Element %d ::: %d\n",i+1, n[i]);
	}
	return 0;
} 


