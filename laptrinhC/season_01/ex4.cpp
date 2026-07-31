#include <stdio.h>
#include <math.h>
int main(){
    float coordinateX1, coordinateX2, coordinateY1,coordinateY2;
    scanf("%f %f %f %f",&coordinateX1,&coordinateY1,&coordinateX2,&coordinateY2);
    float distance= sqrt((coordinateX1-coordinateX2)*(coordinateX1-coordinateX2)+(coordinateY1-coordinateY2)*(coordinateY1-coordinateY2));
    printf("khoang cach giua 2 diem la %f",distance);
    return 0;
}