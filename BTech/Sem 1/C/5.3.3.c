//Write a program to create a nested structure for storing book details
// (title, author, price, and publisher) and display them

#include<stdio.h>
#

struct book {
	char title[30];
	char author[20];
	int price;
	char publisher[20];
}; 

int main()
{
	int n;
	printf("enter no of entries :: ");
	scanf("%n", &n);
	
	struct book *books;
	
	for(int i=0; i<n; i++)
	{
		printf("enter title of book :: ");
		scanf("%[^\n]", &books[i].title);
		printf("enter auther of book :: ");
		scanf("%[^\n]", &books[i].author);
		printf("enter price of book :: ");
		scanf("%d", &books[i].price);
		printf("enter publisher of book :: ");
		scanf("%[^\n]", &books[i].publisher);
	}
	
	for (int i=0; i<n; i++)
	{
		printf("title, auther, price, publisher\n\n");
		printf("%s, %s, %d, %s", &books[i].title, &books[i].author, &books[i].price, &books[i].publisher);
	}
}



