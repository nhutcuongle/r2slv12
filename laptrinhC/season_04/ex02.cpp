#include <stdio.h>

// 1. Hàm kiểm tra một số x có phải là số nguyên tố hay không
int isPrime(int x) {
    if (x < 2) {
        return 0; // Các số nhỏ hơn 2 không phải là số nguyên tố
    }
    for (int i = 2; i * i <= x; i++) {
        if (x % i == 0) {
            return 0; // Chia hết cho số khác -> Không phải số nguyên tố
        }
    }
    return 1; // Là số nguyên tố
}

int main() {
    const int size = 100;
    int number[size], n;

    // 2. Nhập số lượng phần tử n hợp lệ
    do {
        printf("Nhap so luong phan tu n (1 - %d): ", size);
        scanf("%d", &n);
    } while (n <= 0 || n > size);

    // 3. Nhập từng phần tử của mảng từ bàn phím
    printf("\n--- Nhap mang ---\n");
    for (int i = 0; i < n; i++) {
        printf("number[%d] = ", i);
        scanf("%d", &number[i]);
    }

    // 4. In lại mảng vừa nhập
    printf("\nMang vua nhap: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", number[i]);
    }
    printf("\n");

    // 5. Duyệt mảng và in ra các số nguyên tố
    printf("Cac so nguyen to trong mang: ");
    int count = 0; // Biến đếm số lượng số nguyên tố tìm thấy

    for (int i = 0; i < n; i++) {
        if (isPrime(number[i]) == 1) {
            printf("%d ", number[i]);
            count++;
        }
    }

    // Nếu duyệt hết mảng mà không có số nguyên tố nào
    if (count == 0) {
        printf("Khong co so nguyen to nao.");
    }

    printf("\n");
    return 0;
}