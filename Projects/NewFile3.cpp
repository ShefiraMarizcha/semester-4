#include <stdio.h>

#define HARGA_FOUNDATION 70000
#define HARGA_CONCEALER 46000
#define HARGA_LOOSE_POWDER 37000
#define HARGA_BLUSH_ON 51000
#define HARGA_LIP_CREAM 46000

void tampilkanMenuProduk() {
    printf("\n=============================================================\n");
    printf("|                      FIRA SHOPING                         |\n");
    printf("|------------ Selamat datang di Fira Shoping! --------------|\n");
    printf("| 1. Foundation                                   Rp.70.0000|\n");
    printf("| 2. Concealer                                    Rp.46.0000|\n");
    printf("| 3. Loose Powder                                 Rp.37.0000|\n");
    printf("| 4. Blush On                                     Rp.51.0000|\n");
    printf("| 5. Lip Cream                                    Rp.46.0000|\n");
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
                    do {
                        tampilkanMenuShade();
                        scanf("%d", &pilihanShade);

                        if (pilihanShade < 1 || pilihanShade > 4) {
                            printf("Pilihan shade tidak valid. Silakan pilih shade 1-4.\n");
                        }
                    } while (pilihanShade < 1 || pilihanShade > 4);

                    totalHarga += jumlah * HARGA_FOUNDATION;
                    break;
                case 4:
                    do {
                        tampilkanMenuBlushOnShade();
                        scanf("%d", &pilihanShade);

                        if (pilihanShade < 1 || pilihanShade > 3) {
                            printf("Pilihan shade tidak valid. Silakan pilih shade 1-3.\n");
                        }
                    } while (pilihanShade < 1 || pilihanShade > 3);

                    totalHarga += jumlah * HARGA_BLUSH_ON;
                    break;
                case 5:
                    do {
                        tampilkanMenuLipCreamShade();
                        scanf("%d", &pilihanShade);

                        if (pilihanShade < 1 || pilihanShade > 3) {
                            printf("Pilihan shade tidak valid. Silakan pilih shade 1-3.\n");
                        }
                    } while (pilihanShade < 1 || pilihanShade > 3);

                    totalHarga += jumlah * HARGA_LIP_CREAM;
                    break;
                default:
                    printf("Pilihan tidak valid. Silakan pilih produk 1-5.\n");
                    break;
            }

            printf("\n------------------Produk berhasil dipilih-------------------\n");

            // Menampilkan total harga
            printf("Total Harga: Rp%d\n", totalHarga);

            // Menampilkan opsi pembayaran
            do {
                tampilkanMenuPembayaran();
                printf("Silakan pilih metode pembayaran (1-3): ");
                scanf("%d", &pilihanPembayaran);

                if (pilihanPembayaran < 1 || pilihanPembayaran > 3) {
                    printf("Pilihan pembayaran tidak valid. Silakan pilih pembayaran 1-3.\n");
                }
            } while (pilihanPembayaran < 1 || pilihanPembayaran > 3);

            if (pilihanPembayaran == 2) {
                // Menampilkan opsi bank untuk transfer
                do {
                    tampilkanMenuBank();
                    printf("Silakan pilih bank (1-4): ");
                    scanf("%d", &pilihanBank);

                    if (pilihanBank < 1 || pilihanBank > 4) {
                        printf("Pilihan bank tidak valid. Silakan pilih bank 1-4.\n");
                    }
                } while (pilihanBank < 1 || pilihanBank > 4);
            }

            // Menampilkan konfirmasi pembayaran berhasil
            printf("\n-------------Pembayaran telah berhasil--------------\n");
            printf("\n----------Produk dalam proses pengemasan------------\n");
            printf("\n---------Produk telah di serahkan ke kurir----------\n");


            // Menampilkan menu tambahan
            printf("\n----------- Menu Tambahan ------------\n");
            printf("|  1. Kembali ke Menu Utama           |\n");
            printf("|  2. Keluar                          |\n");
            printf("--------------------------------------\n");
            printf("Pilihan (1-2): ");

            int menuTambahan;
            scanf("%d", &menuTambahan);

            if (menuTambahan == 1) {
                // Kembali ke menu utama
                // Continue the loop to display the main menu again
            } else if (menuTambahan == 2) {
                printf("\nTerima kasih telah mampir di Fira Shopping. Sampai jumpa!\n");
                return 0; // Terminate the program
            } else {
                printf("\nPilihan tidak valid. Keluar dari program.\n");
                return 0; // Terminate the program
            }


        } else if (pilihan == 6) {
            printf("Terima kasih telah mampir di Fira Shopping. Sampai jumpa!\n");
        } else {
            printf("Pilihan tidak valid. Silakan pilih produk 1-6.\n");
        }

    } while (pilihan != 6);

    return 0;
}
