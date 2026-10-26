/*
 * Experiment 1: Convert Decimal and Hexadecimal to Binary
 * Lab: Computer Organization & Architecture Lab
 */

#include <stdio.h>
#include <stdlib.h>

void toBinary(unsigned int n) {
    if (n > 1) toBinary(n / 2);
    printf("%d", n % 2);
}

int main() {
    unsigned int dec;
    char hex[20];
    printf("Enter decimal number: ");
    scanf("%u", &dec);
    printf("Enter hexadecimal number: ");
    scanf("%s", hex);
    
    printf("\nDecimal %u in binary: ", dec);
    toBinary(dec);
    printf("\n");
    
    printf("Hexadecimal %s in binary: ", hex);
    toBinary((unsigned int)strtoul(hex, NULL, 16));
    printf("\n");
    
    return 0;
}
