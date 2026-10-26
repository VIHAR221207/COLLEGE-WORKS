/*
 * Experiment 5: Booth's Multiplication Algorithm (8-bit Signed)
 * Lab: Computer Organization & Architecture Lab
 */

#include <stdio.h>

void printBinary(int num, int bits) {
    for (int i = bits - 1; i >= 0; i--) {
        printf("%d", (num >> i) & 1);
    }
}

void arithmeticRightShift(int *A, int *Q, int *Q_minus_1) {
    int msb_A = (*A >> 7) & 1;   // Preserve the sign bit (MSB) of A
    *Q_minus_1 = *Q & 1;        // LSB of Q becomes Q-1
    *Q = (*Q >> 1) & 0x7F;      // Right shift Q
    if (*A & 1) {               // If LSB of A was 1, set MSB of Q to 1
        *Q |= 0x80;
    }
    *A = (*A >> 1) & 0x7F;      // Right shift A
    if (msb_A) {                // Maintain sign bit of A
        *A |= 0x80;
    }
}

int main() {
    int M, Q;
    int A = 0;
    int Q_minus_1 = 0;
    int count = 8;

    printf("=== Booth's Multiplication Algorithm (8-bit Signed) ===\n\n");
    printf("Enter Multiplicand (M): ");
    scanf("%d", &M);
    printf("Enter Multiplier (Q): ");
    scanf("%d", &Q);

    M = M & 0xFF;
    Q = Q & 0xFF;

    printf("\nInitial Values:\n");
    printf("M: "); printBinary(M, 8); printf(" (%d)\n", (char)M);
    printf("Q: "); printBinary(Q, 8); printf(" (%d)\n", (char)Q);
    printf("A: "); printBinary(A, 8); printf("\n");
    printf("Q_-1: %d\n", Q_minus_1);
    printf("Count: %d\n\n", count);

    printf("--------------------------------------------------\n");
    printf("Step\tA\t\tQ\t\tQ_-1\tOperation\n");
    printf("--------------------------------------------------\n");

    for (int i = 1; i <= count; i++) {
        int Q0 = Q & 1;
        if (Q0 == 0 && Q_minus_1 == 1) {
            A = (A + M) & 0xFF;
            printf("%d\t", i);
            printBinary(A, 8); printf("\t");
            printBinary(Q, 8); printf("\t%d\tA = A + M\n", Q_minus_1);
        }
        else if (Q0 == 1 && Q_minus_1 == 0) {
            A = (A - M) & 0xFF;
            printf("%d\t", i);
            printBinary(A, 8); printf("\t");
            printBinary(Q, 8); printf("\t%d\tA = A - M\n", Q_minus_1);
        }

        arithmeticRightShift(&A, &Q, &Q_minus_1);
        printf("%d(ARS)\t", i);
        printBinary(A, 8); printf("\t");
        printBinary(Q, 8); printf("\t%d\tShift Right\n", Q_minus_1);
        printf("--------------------------------------------------\n");
    }

    // Combine A and Q into a 16-bit result
    int product = (A << 8) | Q;
    short signedProduct = (short)product; // Cast to 16-bit signed integer

    printf("\nFinal Result:\n");
    printf("Binary Product (A Q): ");
    printBinary(A, 8); printf(" "); printBinary(Q, 8);
    printf("\nDecimal Product: %d\n", signedProduct);

    return 0;
}
