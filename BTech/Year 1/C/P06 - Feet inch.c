#include<stdio.h>
#include<conio.h>
#include<math.h>
/***********************************************************************
WAP dist measured in inch and display equivalnlnet dis in feet and inch
***********************************************************************/
void main()
{
	int f,i;
	printf("Entervalue in inch :: ");
	scanf("%d",&i);
	f = i / 12;
	i = i % 12;
	printf("Feet :: %d\t;Inch :: %d",f,i);
	
	getch();
}
