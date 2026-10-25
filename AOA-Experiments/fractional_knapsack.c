/* ===========================================================================
   EXPERIMENT 4: Fractional Knapsack using Greedy Method
   =========================================================================== */

#include <stdio.h>

struct Item {
    int value;
    int weight;
};

void sortItems(struct Item items[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            double r1 = (double)items[i].value / items[i].weight;
            double r2 = (double)items[j].value / items[j].weight;
            if (r1 < r2) {
                struct Item temp = items[i];
                items[i] = items[j];
                items[j] = temp;
            }
        }
    }
}

void fractionalKnapsack(int capacity, struct Item items[], int n) {
    sortItems(items, n);
    double totalValue = 0.0;
    printf("\nItem Selection Process:\n");
    for (int i = 0; i < n; i++) {
        if (items[i].weight <= capacity) {
            capacity -= items[i].weight;
            totalValue += items[i].value;
            printf("Took 100%% of item with Weight %d and Value %d\n", items[i].weight, items[i].value);
        } else {
            double fraction = (double)capacity / items[i].weight;
            totalValue += items[i].value * fraction;
            printf("Took %.2f%% of item with Weight %d and Value %d\n", fraction * 100, items[i].weight, items[i].value);
            capacity = 0;
            break;
        }
    }
    printf("\nMaximum Value in Knapsack = %.2f\n", totalValue);
}

int main() {
    int n = 3, capacity = 50;
    struct Item items[] = {{60, 10}, {100, 20}, {120, 30}};

    printf("=== Fractional Knapsack (Greedy Approach) ===\n\n");
    printf("Capacity of Knapsack: %d\n", capacity);
    printf("Items (Value, Weight):\n");
    for (int i = 0; i < n; i++) {
        printf("Item %d: Value = %d Weight = %d\n", i + 1, items[i].value, items[i].weight);
    }

    fractionalKnapsack(capacity, items, n);
    return 0;
}
