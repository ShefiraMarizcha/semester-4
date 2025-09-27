#include <stdio.h>
#include <string.h>

#define JUMLAH_SISWA 3
#define JUMLAH_NILAI 3

// Fungsi untuk mencari indeks siswa berdasarkan nama
int cari_siswa(char *nama_cari, char nama_siswa[][50]) {
    for (int i = 0; i < JUMLAH_SISWA; i++) {
        if (strcmp(nama_siswa[i], nama_cari) == 0) {
            return i;
        }
    }
    return -1;
}

// Fungsi untuk menghitung rata-rata nilai siswa
float hitung_rata_rata(int *nilai) {
    int total_nilai = 0;
    for (int i = 0; i < JUMLAH_NILAI; i++) {
        total_nilai += nilai[i];
    }
    return (float)total_nilai / JUMLAH_NILAI;
}

int main() {
    // Data siswa
    char nama_siswa[JUMLAH_SISWA][50] = {"Septiana Bayu", "Prayoga Agi", "Dirgantara Budi"};
    int nilai_siswa[JUMLAH_SISWA][JUMLAH_NILAI] = {{71, 88, 68}, {82, 67, 75}, {0, 0, 0}}; // Array kedua untuk nilai tugas, kuis, presentasi

    // Input nama siswa yang dicari
    char nama_cari[50];
    printf("Masukkan Nama yang dicari: ");
    scanf(" %[^\n]", nama_cari);  // Menambahkan spasi dan %[^\n] agar dapat membaca nama lengkap

    // Cari siswa dalam array
    int index_siswa = cari_siswa(nama_cari, nama_siswa);

    if (index_siswa != -1) {
        float rata_rata_nilai = hitung_rata_rata(nilai_siswa[index_siswa]);
        printf("Ditemukan. \n ");
        printf("Nilai rata-rata %s: %.2f\n", nama_cari, rata_rata_nilai);
    } else {
        printf("Nama %s tidak ditemukan dalam data siswa.\n", nama_cari);
    }

    return 0;
}
