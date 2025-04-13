#include<stdio.h>

/***************************************************************
	reverse array
***************************************************************/

int main(){
	int e, i, temp, j;
	printf("No. of elements to product :: ");
	scanf("%d", &e);
	int n[e];
	for (i=0; i<e; i++){
		printf("Enter element %d :: ", i+1);
		scanf("%d", &n[i]);
	}
	j  = e-1;
	for (i=0; i<e/2; i++){
		//j = e-i-1
		temp = n[i];
		n[i] = n[j];
		n[j] = temp;
		j--;
	}	
	for (i =0 ;i<e ; i++){
		printf("Element %d ::: %d\n",i+1, n[i]);
	}
	return 0;
} 


