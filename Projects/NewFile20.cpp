#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAHUN 2024
#define BULAN 12
#define MAKS_CATATAN 100

struct Catatan {
    int hari;
    int bulan;
    char teks[100];
};

struct Catatan catatan[MAKS_CATATAN];
int jumlahCatatan = 0;

void tambahCatatan(int tahun, int bulan, int hari, const char *teks) {
    if (jumlahCatatan < MAKS_CATATAN) {
        catatan[jumlahCatatan].hari = hari;
        catatan[jumlahCatatan].bulan = bulan;
        snprintf(catatan[jumlahCatatan].teks, sizeof(catatan[jumlahCatatan].teks), "%s", teks);
        ++jumlahCatatan;
    } else {
        printf("Jumlah maksimum catatan telah tercapai. Tidak dapat menambahkan catatan lebih banyak.\n");
    }
}

void lihatCatatan(int bulan, int hari) {
    printf("\nCatatan untuk bulan %d, tanggal %d:\n", bulan, hari);
    for (int i = 0; i < MAKS_CATATAN; ++i) {
        if (catatan[i].bulan == bulan && catatan[i].hari == hari) {
            printf("%s\n", catatan[i].teks);
        }
    }
}

void cetakKalender(int tahun, int bulan) {
    int hari, hariDalamMinggu = 0;
    char *bulanNama[] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
    int hariPerBulan[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    if ((tahun % 4 == 0 && tahun % 100 != 0) || tahun % 400 == 0)
        hariPerBulan[1] = 29;

    printf("\n---------------%s %d-------------------\n", bulanNama[bulan - 1], tahun);
    printf("\n  Min  Sen  Sel  Rab  Kam  Jum  Sab\n");

    for (hari = 1; hari <= hariPerBulan[bulan - 1]; hari++) {
        // Menandai catatan pada tanggal tertentu
        int memilikiCatatan = 0;
        for (int i = 0; i < MAKS_CATATAN; ++i) {
            if (catatan[i].bulan != 0 && bulan == catatan[i].bulan && hari == catatan[i].hari) {
                memilikiCatatan = 1;
                break;
            }
        }

        if (memilikiCatatan) {
            printf("*%4d", hari);
        } else {
            printf(" %4d", hari);
        }

        if (++hariDalamMinggu > 6) {
            printf("\n");
            hariDalamMinggu = 0;
        }
    }
    printf("\n");
}

int main() {
    system("Color 07"); // Mengubah latar belakang menjadi hitam putih
    int tahun, bulan, hari;
    char pilihan;
    char teks[100];

    printf("\nMasukkan tahun yang diinginkan: ");
    scanf("%d", &tahun);

    do {
        printf("\nMasukkan bulan yang diinginkan (1-12): ");
        scanf("%d", &bulan);

        if (bulan < 1 || bulan > 12) {
            printf("Bulan tidak valid.\n");
            return 1;
        }

        cetakKalender(tahun, bulan);

        do {
            printf("\nMasukkan tanggal untuk menambahkan catatan (1-31): ");
            scanf("%d", &hari);

            if (hari < 1 || hari > 31) {
                printf("Tanggal tidak valid. Harap masukkan nilai antara 1 dan 31.\n");
            }
        } while (hari < 1 || hari > 31);

        printf("Masukkan catatan untuk tanggal %d %c: ", hari, bulanNama);
        scanf(" %[^\n]s", teks);

        tambahCatatan(tahun, bulan, hari, teks);
        printf("Catatan berhasil ditambahkan!\n");

        // Menampilkan catatan yang baru ditambahkan
        lihatCatatan(bulan, hari);

        printf("\nApakah Anda ingin menambahkan catatan untuk tanggal lain? (Y/N): ");
        scanf(" %c", &pilihan);

    } while
