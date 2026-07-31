#include <stdio.h>

// Hàm tính giai thừa
float tinhGiaiThua(int n) {
    float gt = 1;
    for (int i = 1; i <= n; i++) {
        gt *= i;
    }
    return gt;
}

int main() {
    int n;
    printf("Nhap vao so nguyen n: ");
    scanf("%d", &n);

    if (n < 0) {
        printf("khong dinh nghia cho so am!\n");
    } else {
        printf("%d! = %.0f\n", n, tinhGiaiThua(n));
    }

    return 0;
}
4