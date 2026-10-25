/* ===========================================================================
   EXPERIMENT 10: Min-Max Algorithm using Divide and Conquer
   =========================================================================== */

#include <stdio.h>

struct MinMax {
    int min;
    int max;
};

struct MinMax getMinMax(int arr[], int low, int high) {
    struct MinMax result, left, right;
    int mid;

    if (low == high) {
        result.min = arr[low];
        result.max = arr[low];
        return result;
    }

    if (high == low + 1) {
        if (arr[low] < arr[high]) {
            result.min = arr[low];
            result.max = arr[high];
        } else {
            result.min = arr[high];
            result.max = arr[low];
        }
        return result;
    }

    mid = (low + high) / 2;
    left = getMinMax(arr, low, mid);
    right = getMinMax(arr, mid + 1, high);

    result.min = (left.min < right.min) ? left.min : right.min;
    result.max = (left.max > right.max) ? left.max : right.max;

    return result;
}

int main() {
    int arr[] = {15, 8, 20, 5, 12, 30, 2, 18};
    int n = sizeof(arr) / sizeof(arr[0]);

    struct MinMax result = getMinMax(arr, 0, n - 1);

    printf("Minimum Element = %d\n", result.min);
    printf("Maximum Element = %d\n", result.max);

    return 0;
}
