// Write a program that solves a quadratic equation of the form ax^2 + bx + c = 0.
// Prompt the user to enter values for coefficients a, b, and c. Calculate the
// discriminant (delta) using the formula delta = b^2 - 4ac. If delta is positive, calculate
// and display the roots of the equation using the quadratic formula. If delta is zero or
// negative, display an appropriate message.

#include <stdio.h>
#include <math.h>

int main() {
    float a, b, c;
    float delta, x1, x2;

    printf("Nhap he so a, b, c: ");
    scanf("%f %f %f", &a, &b, &c);
    if (a == 0) {
        if (b == 0) {
            if (c == 0) {
                printf("Phuong trinh co vo so nghiem.\n");
            } else {
                printf("Phuong trinh vo nghiem.\n");
            }
        } else {
            printf("Phuong trinh bac nhat co nghiem x = %.2f\n", -c / b);
        }
    } else {
        // Tinh delta = b^2 - 4ac
        delta = b * b - 4 * a * c;

        if (delta > 0) {
            x1 = (-b + sqrt(delta)) / (2 * a);
            x2 = (-b - sqrt(delta)) / (2 * a);
            printf("Phuong trinh co 2 nghiem phan biet:\n");
            printf("x1 = %.2f\n", x1);
            printf("x2 = %.2f\n", x2);
        } else if (delta == 0) {
            x1 = -b / (2 * a);
            printf("Phuong trinh co nghiem kep x1 = x2 = %.2f\n", x1);
        } else {
            printf("Delta = %.2f < 0: Phuong trinh vo nghiem (khong co nghiem thuc).\n", delta);
        }
    }

    return 0;
}