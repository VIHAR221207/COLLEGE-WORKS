/* ===========================================================================
   EXPERIMENT 9: Rabin-Karp Algorithm for String Pattern Matching
   =========================================================================== */

#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define d 256
#define q 101

void rabinKarp(char pattern[], char text[]) {
    int m = strlen(pattern);
    int n = strlen(text);
    int i, j;
    int p = 0;
    int t = 0;
    int h = 1;

    for (i = 0; i < m - 1; i++)
        h = (h * d) % q;

    for (i = 0; i < m; i++) {
        p = (d * p + pattern[i]) % q;
        t = (d * t + text[i]) % q;
    }

    for (i = 0; i <= n - m; i++) {
        if (p == t) {
            bool match = true;
            for (j = 0; j < m; j++) {
                if (text[i + j] != pattern[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                printf("Pattern found at index %d\n", i);
            }
        }
        if (i < n - m) {
            t = (d * (t - text[i] * h) + text[i + m]) % q;
            if (t < 0)
                t = (t + q);
        }
    }
}

int main() {
    char text[] = "AABAACAADAABAABA";
    char pattern[] = "AABA";
    rabinKarp(pattern, text);
    return 0;
}
