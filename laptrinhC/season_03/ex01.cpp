#include <stdio.h>

int main() {
    int i;

    printf("Day so la:\n");
    for (i = 100; i >= 5; i -= 5) {
        printf("%d ", i);
    }
    return 0;
}