#include <stdio.h>

int main() {
    int n, i;
    long long a = 1, b = 1, next;
    printf("Enter the number of terms (n): ");
    scanf("%d", &n);

    if (n <= 0) {
        printf("Please enter a positive integer.\n");
        return 1;
    }

    printf("Fibonacci Series: ");

    for (i = 1; i <= n; i++) {
        if (i == 1) {
            printf("%lld", a);
            continue;
        }
        if (i == 2) {
            printf(", %lld", b);
            continue;
        }

        next = a + b;
        printf(", %lld", next);
        a = b;
        b = next;
    }
    return 0;
}