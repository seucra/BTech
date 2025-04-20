#include<stdio.h>
#include<math.h>

void main()
{
	int x1,x2,y1,y2;
	float res;
	printf("Enter coordinates of pt 1 :: ");
	scanf("%d%d", &x1,&y1);
	printf("Enter coordinates of pt 2 :: ");
	scanf("%d%d", &x2,&y2);
	res = pow( x2-x1, 2) + pow( y2-y1, 2);
	printf("\n\t\t::res:: %f", res);
	
}
