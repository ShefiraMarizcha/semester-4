#include <stdio.h>

#define HARGA_FOUNDATION 70000
#define HARGA_CONCEALER 46000
#define HARGA_LOOSE_POWDER 37000
#define HARGA_BLUSH_ON 51000
#define HARGA_LIP_CREAM 46000

void tampilkanMenuProduk() {
    printf("\n=============================================================\n");
    printf("|                      FIRA SHOPING                         |\n");
    printf("| Selamat datang di Fira Shoping!                           |\n");
    printf("| 1. Foundation                                             |\n");
    printf("| 2. Concealer                                              |\n");
    printf("| 3. Loose Powder                                           |\n");
    printf("| 4. Blush On                                               |\n");
    printf("| 5. Lip Cream                                              |\n");
    printf("| 6. Keluar                                                 |\n");
    printf("=============================================================\n");
}

void tampilkanMenuShade() {
    printf("\nSilakan pilih shade:\n");
    printf("1. Ivory\n");
    printf("2. Beige\n");
    printf("3. Natural\n");
    printf("4. Tan\n");
    printf("Pilihan (1-4): ");
}

void tampilkanMenuBlushOnShade() {
    printf("\nSilakan pilih shade:\n");
    printf("1. Peach\n");
    printf("2. Pinkish\n");
    printf("3. Lavender\n");
    printf("Pilihan (1-3): ");
}

void tampilkanMenuLipCreamShade() {
    printf("\nSilakan pilih shade:\n");
    printf("1. Fancy\n");
    printf("2. Blame\n");
    printf("3. Coral\n");
    printf("Pilihan (1-3): ");
}

void tampilkanMenuPembayaran() {
    printf("\n------------------------------------------------------------\n");
    printf("|                   METODE PEMBAYARAN                       |\n");
    printf("| 1. COD (Bayar Tunai saat Barang Sampai)                   |\n");
    printf("| 2. Transfer Bank                                          |\n");
    printf("| 3. OVO                                                    |\n");
    printf("------------------------------------------------------------\n");
}

void tampilkanMenuBank() {
    printf("\n------------------------------------------------------------\n");
    printf("|                      PILIH BANK                           |\n");
    printf("| 1. Bank BRI                                               |\n");
    printf("| 2. Bank BNI                                               |\n");
    printf("| 3. Bank Mandiri                                           |\n");
    printf("| 4. Bank Jatim                                             |\n");
    printf("------------------------------------------------------------\n");
}

int main() {
    int pilihan;
    int pilihanShade;
    int pilihanPembayaran;
    int pilihanBank;
    int jumlah;

    int totalHarga = 0;

    do {
        tampilkanMenuProduk();
        printf("Silakan pilih produk (1-6): ");
        scanf("%d", &pilihan);

        if (pilihan >= 1 && pilihan <= 5) {
            // Meminta jumlah
            printf("Masukkan jumlah produk yang akan dibeli: ");
            scanf("%d", &jumlah);

            switch (pilihan) {
                case 1:
                case 2:
                case 3:
                    tampilkanMenuShade();
                    totalHarga += jumlah * HARGA_FOUNDATION;
                    break;
                case 4:
                    tampilkanMenuBlushOnShade();
                    totalHarga += jumlah * HARGA_BLUSH_ON;
                    break;
                case 5:
                    tampilkanMenuLipCreamShade();
                    totalHarga += jumlah * HARGA_LIP_CREAM;
                    break;
                default:
                    break;
            }

            scanf("%d", &pilihanShade);
            printf("\n------------------Produk berhasil dipilih-------------------\n");

            // Menampilkan opsi pembayaran
            tampilkanMenuPembayaran();
            printf("Silakan pilih metode pembayaran (1-3): ");
            scanf("%d", &pilihanPembayaran);

            if (pilihanPembayaran == 2) {
                // Menampilkan opsi bank untuk transfer
                tampilkanMenuBank();
                printf("Silakan pilih bank (1-4): ");
                scanf("%d", &pilihanBank);
            }

            printf("\n-------------Selamat produk berhasil di bayar---------------\n");

            // Menampilkan metode pembayaran dan bank yang dipilih
            if (pilihanPembayaran == 2) {
                printf("Anda memilih transfer via ");
                switch (pilihanBank) {
                    case 1:
                        printf("Bank BRI");
                        break;
                    case 2:
                        printf("Bank BNI");
                        break;
                    case 3:
                        printf("Bank Mandiri");
                        break;
                    case 4:
                        printf("Bank Jatim");
                        break;
                    default:
                        break;
                }
                printf(".\n");
            }

            // Menampilkan total harga
            printf("Total pembayaran: Rp%d\n", totalHarga);

            // Produk sedang dalam proses pengemasan
            printf("Produk sedang dalam proses pengemasan...\n");

            printf("\n************************************************************\n");
            printf("Tekan Enter untuk kembali ke menu utama...");
            getchar(); // Mengonsumsi karakter newline
            getchar(); // Menunggu tombol Enter ditekan
        } else if (pilihan == 6) {
            printf("Terima kasih telah mampir di Fira Shoping. Sampai jumpa!\n");
        } else {
            printf("Pilihan tidak valid. Silakan pilih produk 1-6.\n");
        }

    } while (pilihan != 6);

    return 0;
}
