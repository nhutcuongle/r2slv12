 #include <stdio.h>
 int main(){
    int password,solan=0;
    while(solan < 3){
        printf("nhap pass: ");
        scanf("%d",&password);
        if(password == 12345){
            printf("login \n");
            return 0;
        }else{
            printf("login failed\n");
            solan++;
        }
    }
    printf("ban da nhap sai 3 lan, ket thuc chuong trinh");
    return 0;
 }
