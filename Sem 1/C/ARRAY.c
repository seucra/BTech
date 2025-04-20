#include<stdio.h>

/***
Array
***/

void reverserecursive(int x[], int n)
{
	if (n==0)	return;
	printf("%d ", x[n-1]);
	reverserecursive(x, n-1);
}

int sum(int x[], int n)
{
	if (n==0)	return 0;
	return x[n-1]+ sum(x, n-1);
}

int avrage(int x[], int n)
{
	return sum(x, n)/n;
}

int small(int x[], int n)
{
	int s = x[0];
	for(int i=1; i<n; i++)
	{
		if (x[i]<s)		s = x[i];
	}
	return s;
}

int large(int x[], int n)
{
	int l = x[0];
	for(int i=1; i<n; i++)
	{
		if (x[i]>l)		l = x[i];
	}
	return l;
}

int large2nd(int x[], int n)
{
	int l1=x[0], l2=x[0];
	for(int i=0; i<n; i++)
	{
		if (x[i]>l1)
		{
			l2 = l1;
			l1 = x[i];
		}
	
		else if ((x[i] > l2) && (x[i]) != l1)
		{
			l2 = x[i];
		}
	}
	return l2;
}

void take(int x[], int n)
{
	for (int i=0; i<n; i++)
	{
		printf("\tEnter element %d :: ", i+1);
		scanf("%d", &x[i]);
	}
	printf("\n");
}

void display(int x[], int n)
{
	printf("\n\tArray--\n\t\t");
	for (int i=0; i<n; i++)
	{
		printf("%d ", x[i]);
	}
	printf("\n\n");
}

void sort(int x[], int n)
{
	int swapped, temp;
	for(int i=0; i<n-1; i++)
	{
		swapped = 0;
		for(int j=0; j < n-i-1; j++)
		{
			if (x[j] > x[j+1])
			{
				temp = x[j];
				x[j] = x[j+1];
				x[j+1] = temp;
				swapped = 1;
			}
		}
		if (!swapped)	break;
	}
}

void search(int x[], int n, int q)
{
	int y[n], c=0, i; 
	for(i=0; i<n; i++)
	{
		if (x[i] == q)
		{
			y[c] = i+1;
			c += 1;
		}
	}
	if (c ==0)
	{
		printf("Element Not Found.\n");
	}
	else
	{
		printf("Element %d found %d times(s).\nAt indexes :: ",q,c);
		for (i=0; i<c; i++)
		{
			printf("%d ", y[i]);
		}
		printf("\n");
	}
}

void medium(int y[], int n)
{
	printf("\nMedium of Array ");
	if (n%2==0)
	{
		printf("are :: %d, %d\n", y[n/2 - 1], y[n/2]);
	}
	else 
	{
		printf("is :: %d\n", y[n/2]);
	}
}

void reverse(int z[], int n)
{
	int temp;
	sort(z, n);
	for (int i=0; i<=n/2; i++)
	{
		temp = z[i];
		z[i] = z[n-i-1];
		z[n-i-1] = temp;
	}
}

int main()
{
	int x[100], y[100], z[100], n, s, l, l2, q, sm, avg;
	printf("Enter no of Elements\t\t:: ");
	scanf("%d", &n);
	
	take(x, n);
	
	display(x, n);
	printf("\nReverse\t::\n\tArray--\n\t\t");
	reverserecursive(x, n);
	printf("\n");
	
	sm = sum(x, n);
	printf("Sum of all Elements in Array\t::%d\n", sm);
	
	avg = avrage(x, n);
	printf("Avrage of all Elements in Array\t:: %d\n", avg);
	
	s = small(x, n);
	printf("\nSmallest Element\t\t:: %d\n", s);
	l = large(x, n);
	printf("Largest Element\t\t\t:: %d\n", l);
	l2 = large2nd(x, n);
	printf("Second Largest Element\t:: %d\n", l2);
	
	for (int i=0; i<n; i++)
	{
		y[i] = x[i];
	}
	printf("\nOrignal\t::");
	display(x,n);
	sort(y, n);
	printf("Sorted\t::");
	display(y, n);
	
	medium(y, n);
	
	printf("\nEnter Element to Search\t\t:: ");
	scanf("%d", &q);
	search(x, n, q);
	
	for (int i=0; i<n; i++)
	{
		z[i] = x[i];
	}
	printf("\nReverse\t::");
	reverse(z, n);
	display(z, n);
}
