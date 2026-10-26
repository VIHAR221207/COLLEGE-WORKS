/*
 * Experiment 10: Basic File Operations (Create, Write, Read, Append)
 * Lab: Computer Organization & Architecture Lab
 */

#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *fp;
    char text[100];

    // 1. Create and Write to File
    fp = fopen("sample.txt", "w");
    if (fp == NULL) {
        printf("Error creating file!\n");
        return 1;
    }
    fprintf(fp, "Hello, welcome to File Handling in C.\n");
    fclose(fp);
    printf("File created and written successfully.\n");

    // 2. Append to File
    fp = fopen("sample.txt", "a");
    if (fp == NULL) {
        printf("Error opening file for appending!\n");
        return 1;
    }
    fprintf(fp, "This line is appended to the file.\n");
    fclose(fp);
    printf("Data appended successfully.\n");

    // 3. Read from File
    fp = fopen("sample.txt", "r");
    if (fp == NULL) {
        printf("Error opening file for reading!\n");
        return 1;
    }
    printf("\nReading content from file:\n--------------------------\n");
    while (fgets(text, sizeof(text), fp) != NULL) {
        printf("%s", text);
    }
    fclose(fp);

    return 0;
}
