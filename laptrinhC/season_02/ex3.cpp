// : ABC company gives allowances to its employees depending on their
// grade as follows
// Calculate the salary at the end of the month. (Accept Salary and Grade from the user) 
#include <stdio.h>
int main(){
    double basic_salary, salary, allowance;
    char grade;
    printf("nhap vao basic_salary =")   ;
    scanf("%lf",&basic_salary);
    printf("nhap vao grade =");
    scanf(" %c",&grade);
    
    if (grade == 'a' || grade == 'A') {
        allowance =300;
    }
    else if (grade == 'b' || grade == 'B') {
        allowance = 200;
    }else{
        allowance =100;
    }
    salary = basic_salary+allowance;
    printf("luong cuoi cung cua ban la %lf",salary);
    return 0;
}