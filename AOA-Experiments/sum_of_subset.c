/* ===========================================================================
   EXPERIMENT 7: Sum of Subset Algorithm
   =========================================================================== */

#include <stdio.h>
#include <stdbool.h>

#define MAX 100

int set[MAX];
int subset[MAX];
int n, target;
bool found = false;

void sortSet() {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (set[j] > set[j + 1]) {
                int temp = set[j];
                set[j] = set[j + 1];
                set[j + 1] = temp;
            }
        }
    }
}

void subsetSum(int index, int current_sum, int subset_size) {
    if (current_sum == target) {
        found = true;
        printf("Subset found: { ");
        for (int i = 0; i < subset_size; i++) {
            printf("%d ", subset[i]);
        }
        printf("}\n");
        return;
    }

    for (int i = index; i < n; i++) {
        if (current_sum + set[i] > target) {
            continue;
        }
        subset[subset_size] = set[i];
        subsetSum(i + 1, current_sum + set[i], subset_size + 1);
    }
}

int main() {
    int initial_set[] = {3, 4, 5, 6};
    n = sizeof(initial_set) / sizeof(initial_set[0]);
    target = 9;

    for (int i = 0; i < n; i++) {
        set[i] = initial_set[i];
    }

    sortSet();

    printf("Given Set: { ");
    for (int i = 0; i < n; i++) {
        printf("%d ", set[i]);
    }
    printf("}\nTarget Sum: %d\n\n", target);

    printf("Results:\n");
    subsetSum(0, 0, 0);

    if (!found) {
        printf("No subset with the given target sum exists.\n");
    }

    return 0;
}
