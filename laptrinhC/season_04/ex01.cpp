// Write a C program to find the minimum and the maximum value in
// an array 
#include <stdio.h>

int main() {
 const int size = 100;
 int number[size],n,x,solan=0;
    do {
        printf("Nhap n: ");
        scanf("%d", &n);
       
    } while (n < 0 || n > size);
      printf("Nhap x: ");
        scanf("%d", &x); 

    for(int i=0;i<n;i++){
         printf("number[%d]: ", i);
        scanf("%d", &number[i]);
    }
    int max=number[0],min=number[0];

    for(int i=0;i<n;i++){
         printf("\t%d ", number[i]);
        
    }
//max
//      for(int i=0;i<n;i++){
//         if(max < number[i]){
//             max = number[i];
//         }
//     }
//     printf("max la %d\n",max);
// //min
//     for(int i=0;i<n;i++){
//         if(min > number[i]){
//            min = number[i];
//         } 
//     }
//    printf("\nmin la %d",min);


//    int sum =0;
//    for(int i=0;i<n;i++){
//         if(number[i] %2 != 0){
//           sum += number[i];
//         } 
//     }
//    printf("\nsum  la %d",sum);
// //dém số lần x trong chuổi

//     for(int i=0;i<n;i++){
//         if(number[i] == x ){
//           solan++;
         
//         } 
        
//     }
//      printf("\nso lan la %d",solan);
//    //elements divisible by 3 or 5.

//    printf("Cac phan tu chia het cho 3 hoac 5 la: ");
//    for(int i=0;i<n;i++){
//         if(number[i] %3 == 0 ||number[i] %5 == 0){
//            printf(" %d",number[i]);
//         } 
//     }

//      printf("Cac phan tu <0: ");
//      for(int i=0;i<n;i++){
//         if(number[i] < 0){
//            printf(" %d",number[i]);
//         } 
//     }

    int foundEven = 0;
     for(int i=0;i<n;i++){
        if(number[i] %2 == 0){
        foundEven = 1;
        break;
        }
    }
    if(foundEven == 1){
     printf("tat ca phan tu khong la so le");
    }else{
            printf("tat ca phan tu la so le");
    }


    

}