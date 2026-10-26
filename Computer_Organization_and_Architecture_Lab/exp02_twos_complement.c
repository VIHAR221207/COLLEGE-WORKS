/*
 * Experiment 2: 2's Complement of a Binary Number
 * Lab: Computer Organization & Architecture Lab
 */

#include <stdio.h>
#include <string.h>

int main() {
    char binary[100];
    int foundOne = 0;
    
    printf("Enter a binary number: ");
    scanf("%s", binary);
    
    for (int i = strlen(binary) - 1; i >= 0; i--) {
        if (foundOne) {
            binary[i] = (binary[i] == '1') ? '0' : '1';
        } else if (binary[i] == '1') {
            foundOne = 1;
        }
    }
    
    printf("2's complement: %s\n", binary);
    return 0;
}
