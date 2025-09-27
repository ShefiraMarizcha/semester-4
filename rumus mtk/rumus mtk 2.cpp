#include <stdio.h>

int main() {
    float nilai = 40.0;
    float total_nilai = 100.0;
    float persentase = (nilai / total_nilai) * 100;

    printf("Persentase: %.2f%%\n", persentase);
    return 0;
}