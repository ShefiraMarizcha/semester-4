#include <stdio.h>
#include <stdlib.h>

int getHariPertamaMinggu(int tahun) {
    int d;
    d = (((tahun - 1) * 365) + ((tahun - 1) / 4) - ((tahun - 1) / 100) + ((tahun) / 400) + 1) % 7;
    return d;
}

int main() {

    int tahun, bulan, hari, jumlahHariBulan, hariDalamMinggu = 0, hariPertamaMinggu;
    printf("\nMasukkan tahun yang diinginkan: ");
    scanf("%d", &tahun);

    char *bulanNama[] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
    int hariPerBulan[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    if ((tahun % 4 == 0 && tahun % 100 != 0) || tahun % 400 == 0)
        hariPerBulan[1] = 29;

    hariPertamaMinggu = getHariPertamaMinggu(tahun);

    for (bulan = 0; bulan < 12; bulan++) {
        jumlahHariBulan = hariPerBulan[bulan];
        printf("\n\n---------------%s-------------------\n", bulanNama[bulan]);
        printf("\n  Min  Sen  Sel  Rab  Kam  Jum  Sab\n");

        for (hariDalamMinggu = 0; hariDalamMinggu < hariPertamaMinggu; hariDalamMinggu++)
            printf("     ");

        for (hari = 1; hari <= jumlahHariBulan; hari++) {
            printf("%5d", hari);

            if (++hariDalamMinggu > 6) {
                printf("\n");
                hariDalamMinggu = 0;
            }
            hariPertamaMinggu = hariDalamMinggu;
        }
    }

    return 0;
}
