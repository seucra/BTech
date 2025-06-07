#include<stdio.h>

/***************************************************************
	Initializing array element by using user input
***************************************************************/

int main(){
	int e, i;
	float n[100], pro = 1;
	printf("No. of elements to product :: ");
	scanf("%d", &e);
	for (i=0; i<e; i++){
		printf("Enter element %d :: ", i+1);
		scanf("%f", &n[i]);
	}
	for (i=0; i<e; i++){
		pro *= n[i];
	}
	printf("PRODUCT ::: %f", pro);
	return 0;
} 


