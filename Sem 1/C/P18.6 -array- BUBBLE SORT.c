#include<stdio.h>

/***************************************************************
					BUBBLE SORT
***************************************************************/

int main(){
	int a[100],n , i, j, temp;
	printf("Enter no of elements :: ");
	scanf("%d", &n);
	//enter elements
	for (i=0; i<n; i++){
		printf("Enter element %d :: ", i+1);
		scanf("%d", &a[i]);
	}
	//BUBBLE SORT
	for (i=0; i<n-1; i++){
		
		for (j=0; j<n-1; j++){
			if (a[j]>a[j+1]){
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
	}
	//display
	for (i =0 ;i<n ; i++){
		printf("Element %d ::: %d\n",i+1, a[i]);
	}	
	return 0;
} 


