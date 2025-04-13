#include<stdio.h>
#include<conio.h>

/************************************************************
Find Largest out of 3 integers using Conditional Operator
************************************************************/

int main()
{
	int  x,y,z;
	printf("Enter 3 numbers :: ");
	scanf("%d%d%d",&x,&y,&z);
	//x>y?x:y; FOR 2
	//CAN ALSO DO SEPERATLY FOR 3 
	printf("Larger of the 3 given integer is :: %d",x>y?(x>z?x:z):y);
	
}
