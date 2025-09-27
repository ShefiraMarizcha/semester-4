#include <stdio.h>
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

void tampilkanKalender(int tahun, int bulan);
int dapatkanHariDalamBulan(int tahun, int bulan);
void cetakHeader(int bulan, int tahun);
void cetakBulan(int tahun, int bulan);
void cetakCatatan(int hari, int bulan);
void tambahCatatan(int hari, int bulan, const char* teks);
void lihatCatatan(int tahun, int bulan, int hari);

int main() {
    int tahun = TAHUN;

    while (1) {
        int bulan;
        printf("\nMasukkan bulan (1-12) (0 untuk keluar): ");
        scanf("%d", &bulan);

        if (bulan < 1 || bulan > 12) {
            if (bulan == 0) {
                printf("Keluar dari program. Selamat tinggal!\n");
                break;
            }
            printf("Bulan tidak valid. Harap masukkan nilai antara 1 dan 12.\n");
            continue;
        }

        tampilkanKalender(tahun, bulan);

        int hari;
        printf("\nMasukkan hari untuk menambahkan atau melihat catatan (1-31) (0 untuk kembali ke menu): ");
        scanf("%d", &hari);

        if (hari < 0 || hari > 31) {
            printf("Hari tidak valid. Harap masukkan nilai antara 1 dan 31.\n");
            continue;
        }

        if (hari == 0) {
            continue;
        }

        char teks[100];

        // Cek apakah hari tersebut memiliki catatan
        lihatCatatan(tahun, bulan, hari);

        printf("\nMasukkan catatan untuk hari %d (tekan Enter untuk melewati): ", hari);
        scanf(" %[^\n]s", teks);

        if (strlen(teks) > 0) {
            tambahCatatan(hari, bulan, teks);
            printf("Catatan berhasil ditambahkan!\n");
        }
    }

    return 0;
}

void tampilkanKalender(int tahun, int bulan) {
    cetakHeader(bulan, tahun);
    cetakBulan(tahun, bulan);
}

int dapatkanHariDalamBulan(int tahun, int bulan) {
    int hariDalamBulan[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Sesuaikan untuk tahun kabisat
    if ((tahun % 4 == 0 && tahun % 100 != 0) || (tahun % 400 == 0 && bulan == 2)) {
        hariDalamBulan[2] = 29;
    }

    return hariDalamBulan[bulan];
}

void cetakHeader(int bulan, int tahun) {
    const char* namaBulan[] = {"", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

    printf("\n-----------------------------\n");
    printf("      Kalender %s %d\n", namaBulan[bulan], tahun);
    printf("-----------------------------\n");
    printf(" Min Sen Sel Rab Kam Jum Sab\n");
}

void cetakBulan(int tahun, int bulan) {
    int hariDalamBulan = dapatkanHariDalamBulan(tahun, bulan);
    int hariDalamSeminggu = 7;
    int hariDalamMinggu = 0;
    int hari = 1;

    while (hari <= hariDalamBulan) {
        while (hariDalamSeminggu < 7 && hari <= hariDalamBulan) {
            printf("%4d", hari);

            // Cetak catatan untuk hari
            cetakCatatan(hari, bulan);

            printf(" ");
            ++hari;
            ++hariDalamSeminggu;
        }

        printf("\n");
        hariDalamSeminggu = 0;
    }
}

void cetakCatatan(int hari, int bulan) {
    // Cetak catatan untuk hari
    for (int i = 0; i < MAKS_CATATAN; ++i) {
        if (catatan[i].hari != 0 && catatan[i].bulan != 0) {
            if (hari == catatan[i].hari && bulan == catatan[i].bulan) {
                printf(" [%d]", i + 1);
            }
        }
    }
}

void tambahCatatan(int hari, int bulan, const char* teks) {
    if (jumlahCatatan < MAKS_CATATAN) {
        catatan[jumlahCatatan].hari = hari;
        catatan[jumlahCatatan].bulan = bulan;
        snprintf(catatan[jumlahCatatan].teks, sizeof(catatan[jumlahCatatan].teks), "%s", teks);
        ++jumlahCatatan;
    } else {
        printf("Jumlah maksimum catatan telah tercapai. Tidak dapat menambahkan catatan lebih banyak.\n");
    }
}

void lihatCatatan(int tahun, int bulan, int hari) {
    // Cek apakah hari tersebut memiliki catatan
    for (int i = 0; i < MAKS_CATATAN; ++i) {
        if (catatan[i].hari != 0 && catatan[i].bulan != 0) {
            if (hari == catatan[i].hari && bulan == catatan[i].bulan) {
                printf("\nCatatan untuk tanggal %d %s %d:\n", hari, (bulan == 0 || bulan > 12) ? "" : "bulan", bulan);
                printf("%s\n", catatan[i].teks);

                char pilihan;
                printf("\nApakah Anda ingin menambahkan catatan baru untuk tanggal ini? (y/n): ");
                scanf(" %c", &pilihan);

                if (pilihan == 'n' || pilihan == 'N') {
                    return;  // Jika pengguna tidak ingin menambahkan catatan baru
                }
            }
        }
    }
}
