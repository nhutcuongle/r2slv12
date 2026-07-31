// Write a program to accept 2 numbers and tell whether the
// product of the two numbers is equal to or greater than 1000. 

#include <stdio.h>
int main(){
int num1, num2;
printf("nhập 2 số :");
scanf("%d%d", &num1,&num2);
int tich=num1*num2;
if(tich>=1000){
    printf("tích lớn hơn 1000");
}else{
    printf("tích nhỏ hơn 1000");
}
}