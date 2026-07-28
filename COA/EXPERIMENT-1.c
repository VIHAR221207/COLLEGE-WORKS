#include <stdio.h>
#include <stdlib.h>

// Function to print the binary representation of an unsigned integer
void printBinary(unsigned int num) {
    if (num == 0) {
        printf("0");
        return;
    }

    int started = 0;
    // Iterate through all 32 bits from most significant to least significant
    for (int i = sizeof(num) * 8 - 1; i >= 0; i--) {
        int bit = (num >> i) & 1;
        
        // Skip leading zeros
        if (bit == 1) {
            started = 1;
        }
        if (started) {
            printf("%d", bit);
        }
    }
}

int main() {
    unsigned int decNum;
    char hexStr[32];
    unsigned int hexNum;

    // Read decimal input
    printf("Enter a decimal number: ");
    if (scanf("%u", &decNum) != 1) {
        printf("Invalid input.\n");
        return 1;
    }

    // Read hexadecimal input (e.g., 1A, FF, 2C)
    printf("Enter a hexadecimal number: ");
    scanf("%31s", hexStr);

    // Convert hexadecimal string to an unsigned integer (base 16)
    hexNum = (unsigned int)strtoul(hexStr, NULL, 16);

    // Display Results
    printf("\n--- Binary Conversion Results ---\n");
    printf("Decimal (%u)    -> Binary: ", decNum);
    printBinary(decNum);
    printf("\n");

    printf("Hexadecimal (%s) -> Binary: ", hexStr);
    printBinary(hexNum);
    printf("\n");

    return 0;
}