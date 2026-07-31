 #include <stdio.h>
 int main(){
    int n;
     do {
        printf("Nhap vao diem (0 - 100): ");
        scanf("%d", &n);
        if (n > 10 || n < 1) {
            printf("Diem khong hop le! Vui long nhap lai (tu 0 den 100).\n");
        }
    } while (n > 10 || n < 1);
     for(int i=1;i<=10;i++){
         printf("%d x %d = %d\n",n,i,i*n);
    }
    return 0;
 }
