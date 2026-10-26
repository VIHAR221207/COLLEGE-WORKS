/*
 * Experiment 7: Direct Mapping Technique of Cache Memory
 * Lab: Computer Organization & Architecture Lab
 */

#include <stdio.h>

#define MAX_LINES 100

int main() {
    int cache[MAX_LINES];
    int num_lines, block_num, choice;

    printf("Enter the number of cache lines: ");
    scanf("%d", &num_lines);

    // Step 3: Initialize all cache lines as empty (-1 represents empty)
    for (int i = 0; i < num_lines; i++) {
        cache[i] = -1;
    }

    do {
        // Step 4: Input memory block number
        printf("\nEnter memory block number to access: ");
        scanf("%d", &block_num);

        // Step 5: Calculate cache line index
        int line = block_num % num_lines;
        printf("Mapped Cache Line = %d %% %d = Cache Line %d\n", block_num, num_lines, line);

        // Step 6-8: Check for Hit or Miss
        if (cache[line] == block_num) {
            printf("Status: CACHE HIT\n");
        } else {
            printf("Status: CACHE MISS\n");
            cache[line] = block_num; // Store memory block in calculated line
        }

        // Step 9: Display current cache contents
        printf("\n--- Cache Status ---\n");
        printf("Line\tBlock\n");
        printf("---------------------\n");
        for (int i = 0; i < num_lines; i++) {
            if (cache[i] == -1) {
                printf("%d\tEmpty\n", i);
            } else {
                printf("%d\tBlock %d\n", i, cache[i]);
            }
        }

        // Step 10: Check if user wants to continue
        printf("\nDo you want to access another memory block? (1=Yes, 0=No): ");
        scanf("%d", &choice);
    } while (choice == 1);

    return 0;
}
