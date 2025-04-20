#include <stdio.h>

/************************************************************
=============================================================
************************************************************/

int fac(int n){
	long p=1;
	for (int i=1;i<=n ;i++){
		p*=i;
	}
	return p;
}

int pwr(float x, int y){
	double res = 1.0;
	for (int i=1; i<=y; i++){
		res *= x;
	}
	return res;
}

int menu(){
	int ch, ck = 0;
	do{
	printf("\n\t0. Exit\n\t1. Addition\n\t2. Substraction\n\t3. Multilication\n\t4. Division\n");
	printf("\t5. Floor Division\n\t6. Ceiling Division\n\t7. Factorial\n\t8. Armstrong\n");
	printf("\t9. Sum of AP\n\t10. Combination\n\t11. Premutation\n\t12. Fibbonacci Series\n");
	printf("\t13. x^y\n\t14.Sum of Sin Series\n");
	printf("\nEnter Your Choise :: ");
	scanf("%d", &ch);
	if (ch<0 || ch>14){
		printf("\n\t\tWORNG CHOISE!! Enter Again.\n");
		ck = 1;
	}
	if (ch==0){
		printf("\n\n\t\t\tEXITING...");
		ck = 1;
	}

	}while (ch<0 || ch>14);
	if (ck)		ch = menu();
	return ch;
}

int main() 
{
    int n1, n2, ch, n3;
    float nf1, nf2, nf3;
    long res;
    double resf;
	
	printf("\t\tCALCULATOR\n");
	ch = menu();
	while (ch){
	
		if (ch==1){
			break;
		}
	
		else if (ch==7){
			printf("\nNumber to Calculate Factorial of :: ");
			scanf("%d", &n1);
			res = fac(n1);
			printf("Factorial of %d ::: %ld\n", n1, res);
		}
	
		else if (ch==13){
			printf("For : x^y : enter x, y :: ");
			scanf("%f%d", &nf1, &n2);
			resf = pwr(nf1, n2);
			printf("x^y ::: %lf\n", resf);
		}
	
		else if (ch==14){
			
		}
	
		ch = menu();
	}
}












