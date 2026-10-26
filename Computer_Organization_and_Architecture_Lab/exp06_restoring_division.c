/*
 * Experiment 6: Restoring Division Algorithm (8-bit Unsigned)
 * Lab: Computer Organization & Architecture Lab
 */

#include <stdio.h>

void printBinary(unsigned int num) {
    for (int i = 7; i >= 0; i--) {
        printf("%d", (num >> i) & 1);
    }
}

int main() {
    unsigned int A = 0;
    unsigned int Q, M;
    int count = 8;

    printf("=== Restoring Division Algorithm (8-bit Unsigned) ===\n\n");
    printf("Enter Dividend (Q): ");
    scanf("%u", &Q);
    printf("Enter Divisor (M): ");
    scanf("%u", &M);

    Q = Q & 0xFF;
    M = M & 0xFF;

    printf("\nInitial Values:\n");
    printf("M: "); printBinary(M); printf(" (%u)\n", M);
    printf("Q: "); printBinary(Q); printf(" (%u)\n", Q);
    printf("A: "); printBinary(A); printf(" (0)\n");
    printf("Count: %d\n\n", count);

    printf("--------------------------------------------------\n");
    printf("Step\tA\t\tQ\t\tOperation\n");
    printf("--------------------------------------------------\n");

    for (int i = 1; i <= count; i++) {
        // Shift left combined register [A, Q]
        unsigned int combined = ((A << 8) | Q) << 1;
        A = (combined >> 8) & 0xFF;
        Q = combined & 0xFF;

        // Subtract M from A
        int tempA = (int)A - (int)M;
        if (tempA < 0) {
            // A < 0: Restore A, set Q0 = 0
            Q = Q & 0xFE;
            printf("%d\t", i);
            printBinary(A); printf("\t");
            printBinary(Q); printf("\tShift Left & Sub (A < 0 -> Restore A, Q0 = 0)\n");
        } else {
            // A >= 0: Keep subtracted A, set Q0 = 1
            A = (unsigned int)tempA & 0xFF;
            Q = Q | 1;
            printf("%d\t", i);
            printBinary(A); printf("\t");
            printBinary(Q); printf("\tShift Left & Sub (A >= 0 -> Keep A, Q0 = 1)\n");
        }
        printf("--------------------------------------------------\n");
    }

    printf("\nFinal Result:\n");
    printf("Quotient (Q): "); printBinary(Q); printf(" (%u)\n", Q);
    printf("Remainder (A): "); printBinary(A); printf(" (%u)\n", A);

    return 0;
}
