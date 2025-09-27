#include <stdio.h>
#include <string.h>

// Fungsi untuk mencari indeks siswa berdasarkan nama
int cari_siswa(char *nama_cari, char nama_siswa[][50], int jumlah_siswa) {
    for (int i = 0; i < jumlah_siswa; i++) {
        if (strcmp(nama_siswa[i], nama_cari) == 0) {
            return i;
        }
    }
    return -1;
}

// Fungsi untuk menghitung rata-rata nilai siswa
float hitung_rata_rata(int *nilai, int jumlah_nilai) {
    int total_nilai = 0;
    for (int i = 0; i < jumlah_nilai; i++) {
        total_nilai += nilai[i];
    }
    return (float)total_nilai / jumlah_nilai;
}

int main() {
    // Data siswa
    char nama_siswa[3][50] = {"Septiana Bayu", "Prayoga Agi", "Dirgantara Budi"};
    int nilai_siswa[3][3] = {{71, 88, 68}, {82, 67, 75}, {0, 0, 0}}; // Array kedua untuk nilai tugas, kuis, presentasi

    // Input nama siswa yang dicari
    char nama_cari[50];
    printf("Masukkan Nama yang dicari: ");
    scanf("%s", nama_cari);

    // Cari siswa dalam array
    int index_siswa = cari_siswa(nama_cari, nama_siswa, 3);

    if (index_siswa != -1) {
        float rata_rata_nilai = hitung_rata_rata(nilai_siswa[index_siswa], 3);
        printf("Ditemukan Nilai rata-rata %s: %.2f\n", nama_cari, rata_rata_nilai);
    } else {
        printf("Nama %s tidak ditemukan dalam data siswa.\n", nama_cari);
    }

    return 0;
}
