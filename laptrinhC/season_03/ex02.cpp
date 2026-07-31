// Accept two numbers num1 and num2. Find the sum of all odd numbers
// between the two numbers entered. 
#include <stdio.h>

int main() {
    int num1, num2;
    int sum = 0;
    printf("Nhap vao hai so num1 va num2: ");
    scanf("%d %d", &num1, &num2);
    if (num1 > num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
    for (int i = num1; i < num2; i++) {
        if (i % 2 != 0) {
            sum += i;
            printf("%d\t",i);
        }
    }

    printf("\nTong cac so le giua %d va %d la: %d\n", num1, num2, sum);

    return 0;
}