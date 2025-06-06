// Array: Sorting

#include <stdio.h>
#include <stdlib.h>

void print(int arr[], int n)
{
    for (int i=0; i<n; i++)
    {
        printf(" %d", arr[i]);
    }
    printf("\n");
}

void bubblesort(int arr[], int n)
{
    for (int i=0; i<n; i++)
    {
        for (int j=0; j<n-i-1; j++)
        {
            if (arr[j] > arr[j+1])
            {
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

int main() {
    int arr[] = {8,9,7,6,5,4,3,2,1};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Array: \n");
    print(arr, n);
    
    int arr1[] = {9,8,7,6,5,4,3,2,1};
    bubblesort(arr1, n); 
    printf("Bubble Sorted Array: \n");
    print(arr1, n);
    printf("\n\n");

    printf("Array: \n");
    print(arr, n);
/**
    int arr2[] = {9,8,7,6,5,4,3,2,1};
    insertionsort(arr2, n);
    printf("Insertion Sorted Array: \n");
    print(arr2, n);
*/ 
    return 0;
}