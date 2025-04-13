#include <stdio.h>

int isPrime(int num, int divisor) {
	if (divisor == 1)
		return 1; 
	if (num % divisor == 0)
		return 0; 
	return isPrime(num, divisor - 1);
}

int main() {
	int start = 100, end = 997;
	printf("Prime numbers between %d and %d are:\n", start, end);
	if (start > end){
		printf("wrong input!!");
		return;
	}
	do{
		if (isPrime(start, start / 2)) {
			printf("%d ", start); 
    	}
    	start += 1;
    }
    while (start != end);
    return 0;
}

