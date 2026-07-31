#include <stdio.h>

int main() {
int salary = 12000;
float DA = 0.12*salary;
int HRA = 150;
int TA = 120;
int orthers=450;
float PF = 0.14*salary;
float IT = 0.15*salary;
float Net_salary = salary + DA + HRA + TA + orthers - (PF + IT);
printf("gia tri la : %.2f",Net_salary)  ;
}
