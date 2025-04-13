#include<stdio.h>
#include<conio.h>

/**********************************************************************************
							ROOTS OF QUADRATIC EQN
==================================================================================
				WAP to Identify Vowel
==================================================================================
								ax2+bx+c=0

**********************************************************************************/

int main()
{
	char ch;
	printf("\nEnter Charecter :: ");
	scanf("%c",&ch);
	if (ch =='a'||ch =='e'||ch =='i'||ch =='o'||ch =='u')
	{
		printf("\n\t:Charecter is Vowel:\n\n");
	}
	else	if (ch>='A' && ch<='z')
			{
				printf("\n\t:Its Consonant:\n\n");
			}
			else 	if  ( ch>='0' && ch<='9' )
					{
						printf("\n\t:Charecter is integer:\n\n");
					}
					else
					{
						printf("\n\t:Charecter is Special Charecter:\n\n");
					}
	getch();
}
