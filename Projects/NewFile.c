#include <stdio.h>
#include <string.h>

#define MAX_SISWA 3
#define MAX_NILAI 4

void cariSiswa(char nama_cari[], char nama_siswa[MAX_SISWA][50], int nilai_tugas[MAX_SISWA][3], int nilai_presentasi[MAX_SISWA]) {
    int i;
    for (i = 0; i < MAX_SISWA; i++) {
        if (strcmp(nama_siswa[i], nama_cari) == 0) {
            printf("Ditemukan\n");
            int total_nilai = nilai_tugas[i][0] + nilai_tugas[i][1] + nilai_tugas[i][2] + nilai_presentasi[i];
            float rata_rata = (float)total_nilai / MAX_NILAI;
            printf("Nilai rata-rata %s = %.2f\n", nama_cari, rata_rata);
            return;
        }
    }
    printf("Siswa tidak ditemukan\n");
}

int main() {
    char nama_siswa[MAX_SISWA][50] = {"Septiana Bayu", "Prayoga Semua", "Dirgantara Budi"};
    int nilai_tugas[MAX_SISWA][3] = {{71, 88}, {77, 85, 68}, {82, 67}};
    int nilai_presentasi[MAX_SISWA] = {0, 0, 75};

    char nama_cari[50];
    printf("Masukkan Nama yang dicari: ");
    fgets(nama_cari, sizeof(nama_cari), stdin);
    nama_cari[strcspn(nama_cari, "\n")] = '\0'; // Menghapus karakter newline dari input

    cariSiswa(nama_cari, nama_siswa, nilai_tugas, nilai_presentasi);

    return 0;
}