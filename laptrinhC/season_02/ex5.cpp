// Write a program to show your computer’s capabilities. The user types in
// a letter of the alphabet and your program should display the corresponding language
// or package available. Some sample input and output is given below : 
// B or b Basic
// C or c Cobol
// f or F Fortran
// p or P Pascal
// V or V Visual C++

#include <stdio.h>

int main() {
    char choice;
    printf("Nhap vao mot ky tu: ");
    scanf(" %c", &choice);
    switch (choice) {
        case 'B':
        case 'b':
            printf("Basic\n");
            break;
        case 'C':
        case 'c':
            printf("Cobol\n");
            break;
        case 'F':
        case 'f':
            printf("Fortran\n");
            break;
        case 'P':
        case 'p':
            printf("Pascal\n");
            break;f
        case 'V':
        case 'v':
            printf("Visual C++\n");
            break;
        default:
            printf("Khong tim thay ngon ngu/goi phan mem tuong ung!\n");
            break;
    }

    return 0;
}