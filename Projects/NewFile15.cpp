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

int getHariPertamaMinggu(int tahun) {
    int d;
    d = (((tahun - 1) * 365) + ((tahun - 1) / 4) - ((tahun - 1) / 100) + ((tahun) / 400) + 1) % 7;
    return d;
}

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
    printf("\nCatatan untuk tanggal %d %d:\n", bulan, hari);
    for (int i = 0; i < MAKS_CATATAN; ++i) {
        if (catatan[i].hari == hari && catatan[i].bulan == bulan) {
            printf("%s\n", catatan[i].teks);
        }
    }
}

int main() {
    system("Color 07"); // Mengubah latar belakang menjadi hitam putih
    int tahun, bulan, hari, jumlahHariBulan, hariDalamMinggu = 0, hariPertamaMinggu;
    printf("\nMasukkan tahun yang diinginkan: ");
    scanf("%d", &tahun);

    char *bulanNama[] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
    int hariPerBulan[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    if ((tahun % 4 == 0 && tahun % 100 != 0) || tahun % 400 == 0)
        hariPerBulan[1] = 29;

    hariPertamaMinggu = getHariPertamaMinggu(tahun);

    printf("\nMasukkan bulan yang diinginkan (1-12): ");
    scanf("%d", &bulan);

    if (bulan < 1 || bulan > 12) {
        printf("Bulan tidak valid.\n");
        return 1;
    }

    jumlahHariBulan = hariPerBulan[bulan - 1];

    printf("\n\n---------------%s-------------------\n", bulanNama[bulan - 1]);
    printf("\n  Min  Sen  Sel  Rab  Kam  Jum  Sab\n");

    for (hariDalamMinggu = 0; hariDalamMinggu < hariPertamaMinggu; hariDalamMinggu++)
        printf("     ");

    for (hari = 1; hari <= jumlahHariBulan; hari++) {
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

    // Meminta input untuk menambahkan catatan
    printf("\n\nMasukkan tanggal untuk menambahkan catatan (1-%d): ", jumlahHariBulan);
    scanf("%d", &hari);

    if (hari < 1 || hari > jumlahHariBulan) {
        printf("Tanggal tidak valid untuk bulan ini.\n");
        return 1;
    }

    char teks[100];
    printf("Masukkan catatan untuk tanggal %d %s: ", hari, bulanNama[bulan - 1]);
    scanf(" %[^\n]s", teks);

    tambahCatatan(tahun, bulan, hari, teks);
    printf("Catatan berhasil ditambahkan!\n");

    // Menampilkan catatan yang baru ditambahkan
    lihatCatatan(bulan, hari);

    return 0;
}
