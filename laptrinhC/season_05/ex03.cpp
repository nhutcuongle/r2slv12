#include <stdio.h>

// Hàm nhập và kiểm tra điểm cho một môn học (0 đến 10)
float nhapDiemHopLe(const char *tenMon) {
    float diem;
    do {
        printf("Nhap diem mon %s (0 - 10): ", tenMon);
        scanf("%f", &diem);
        if (diem < 0 || diem > 10) {
            printf("Diem khong hop le! Vui long nhap lai trong khoang 0 - 10.\n");
        }
    } while (diem < 0 || diem > 10);
    return diem;
}

// 1. Hàm nhập điểm các môn học (dùng Tham chiếu trong C++, không dùng con trỏ)
void inputMark(float &db, float &c, float &oop, float &java) {
    printf("\n--- NHAP DIEM CAC MON HOC ---\n");
    db = nhapDiemHopLe("Database");
    c = nhapDiemHopLe("C");
    oop = nhapDiemHopLe("OOP");
    java = nhapDiemHopLe("Java");
    printf(">> Nhap diem thanh cong!\n");
}

// 2. Hàm tính GPA hệ 4 từ điểm hệ 10 trung bình
float calculateGPA(float db, float c, float oop, float java) {
    float avg10 = (db + c + oop + java) / 4.0f;
    float gpa4 = (avg10 / 10.0f) * 4.0f;
    return gpa4;
}
// 3. Hàm hiển thị GPA
void displayGPA(float gpa4) {
    printf("\n GPA (He 4): %.2f / 4.00\n", gpa4);
}

// 4. Hàm hiển thị xếp loại (Rank)
void displayRank(float gpa4) {
    printf("\n>> Xep loai: ");
    if (gpa4 >= 3.60f) {
        printf("Excellent\n");
    } else if (gpa4 >= 3.20f) {
        printf("Good\n");
    } else if (gpa4 >= 2.50f) {
        printf("Fair\n");
    } else if (gpa4 >= 2.00f) {
        printf("Average\n");
    } else {
        printf("Weak\n");
    }
}

int main() {
    float db = 0, c = 0, oop = 0, java = 0;
    int hasInput = 0;
    int choice;

    do {
        printf("\n================ MENU ================\n");
        printf("1. Input mark\n");
        printf("2. Display GPA\n");
        printf("3. Display Rank\n");
        printf("4. Quit\n");
        printf("======================================\n");
        printf("Chon chuc nang (1-4): ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                inputMark(db, c, oop, java); 
                hasInput = 1;
                break;
            case 2:
                if (!hasInput) {
                    printf("\n[!] Ban chua nhap diem. Vui long chon 1 de nhap diem truoc!\n");
                } else {
                    float gpa = calculateGPA(db, c, oop, java);
                    displayGPA(gpa);
                }
                break;
            case 3:
                if (!hasInput) {
                    printf("\n[!] Ban chua nhap diem. Vui long chon 1 de nhap diem truoc!\n");
                } else {
                    float gpa = calculateGPA(db, c, oop, java);
                    displayRank(gpa);
                }
                break;
            case 4:
                printf("\nThoat chuong trinh. Tam biet!\n");
                break;
            default:
                printf("\n[!] Lua chon khong hop le. Vui long chon tu 1 den 4!\n");
        }
    } while (choice != 4);

    return 0;
}
