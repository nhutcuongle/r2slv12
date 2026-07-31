// Write a program to accept 2 numbers. Calculate the difference
// between the two values. 
#include<stdio.h>
int main(){
    int a,b;
    printf("nhap 2 so :");
    scanf("%d%d",&a,&b);
    int diff=a-b;
    if (diff == a) {
            printf("Difference is equal to value 1\n");
        } 
        else if (diff == b) {
            printf("Difference is equal to value 2\n");
        } 
        else {
            printf("Difference is not equal to any of the values entered\n");
        }
        return 0;
}