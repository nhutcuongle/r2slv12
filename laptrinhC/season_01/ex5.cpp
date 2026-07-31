#include <math.h>
#include <stdio.h>

int main() {
    double canhA, canhB, canhC;
    double s, dien_tich;
    printf("=== CHUONG TRINH TINH DIEN TICH TAM GIAC (HERON) ===\n");
    printf("Nhap do dai canh a: ");
    scanf("%lf", &canhA);
    printf("Nhap do dai canh b: ");
    scanf("%lf", &canhB);
    printf("Nhap do dai canh c: ");
    scanf("%lf", &canhC);
    if (canhA > 0 && canhB > 0 && canhC > 0 && (canhA + canhB > canhC) &&
        (canhA + canhC > canhB) && (canhB + canhC > canhA)) {
        s = (canhA + canhB + canhC) / 2.0;
        dien_tich = sqrt(s * (s - canhA) * (s - canhB) * (s - canhC));
        printf("Nua chu vi (s): %.2lf\n", s);
        printf("Dien tich tam giac: %.2lf\n", dien_tich);
    } else {
        printf("\n[Loi] Do dai 3 canh khong hop le! Ba canh khong the tao thanh tam giac.\n");
    }
    return 0;
}

