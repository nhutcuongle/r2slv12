#include <stdio.h>

#define PI 3.14159f
float tinhChuVi(float r) {
    return 2 * PI * r;
}
float tinhDienTich(float r) {
    return PI * r * r;
}
int main() {
    float r;
    printf("Nhap ban kinh hinh tron (r): ");
    scanf("%f", &r);

    if (r <= 0) {
        printf("Ban kinh phai lon hon 0!\n");
    } else {
        float chuVi = tinhChuVi(r);
        float dienTich = tinhDienTich(r);
        printf("Chu vi hinh tron: %.2f\n", chuVi);
        printf("Dien tich hinh tron: %.2f\n", dienTich);
    }

    return 0;
}
