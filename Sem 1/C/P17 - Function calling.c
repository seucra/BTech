#include <stdio.h>

/************************************************************
=============================================================
************************************************************/

int gr8st(int a, int b ,int c){
	a = (a>b) ? ((a>c) ? a : c) : ((b>c) ? b : c);
	return a;
}

int main(){
	int x, y, z, l;
	printf("a,b,c :: ");
	scanf("%d%d%d", &x, &y, &z);
	l = gr8st(x,y,z);
	printf("Greatest :: %d", l);
	getch();
	return 0;
}

