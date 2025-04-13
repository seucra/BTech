#include <stdio.h>

/***********************************************
User input n, calculate sin(x) till n terms 
sin(x) = x - x^3/3! + x^5/5! - x^7/7! + ... 
***********************************************/

double fact(int n) {
    int i;
    double res = 1.0; 
    for (i = 1; i <= n; i++) {
        res *= i;
    }
    return res;
}

double pow(int x, int e) {
    int i;
    double p = 1.0; 
    for (i = 1; i <= e; i++) {
        p *= x;
    }
    return p;
}

double sum0n(int x, int n) {
    int i;
    double sum = 0.0; 
    for (i = 0; i < n; i++) {
        int exp = 2 * i + 1; 
        double term = pow(x, exp) / fact(exp); 
        if (i % 2 == 0) {
            sum += term;  
        } else {
            sum -= term;  
        }
    }
    return sum;
}

int main() {
    int n, x;
    
    printf("Enter x (in radians) :: ");
    scanf("%d", &x);
    printf("Enter n (number of terms) :: ");
    scanf("%d", &n);
    
    printf("Sin(%d) up to %d terms = %.6f\n", x, n, sum0n(x, n));
    
    return 0;
}

