// Write a program to evaluate the Grade of a student for the following
// constraints:
// If marks > 75 – grade A
// If 60 < marks < 75 – grade B
// If 45 < marks<60 – grade C
// If 35 < marks<45 - grade D
// If marks < 35 – grade E 

#include <stdio.h>

int main() {
    float mask;
    do {
        printf("Nhap vao diem (0 - 100): ");
        scanf("%f", &mask);
        if (mask < 0 || mask > 100) {
            printf("Diem khong hop le! Vui long nhap lai (tu 0 den 100).\n");
        }
    } while (mask < 0 || mask > 100);

    if (mask > 75) {
        printf("Grade A\n");
    } else if (mask > 60 && mask <=75) {
        printf("Grade B\n");
    } else if (mask > 45 && mask <=60) {
        printf("Grade C\n");
    } else if (mask >= 35 && mask<=45) {
        printf("Grade D\n");
    } else {
        printf("Grade E\n");
    }

    return 0;
}