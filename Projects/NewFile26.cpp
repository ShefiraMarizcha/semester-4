#include <stdio.h>

// Fungsi untuk menampilkan menu produk
void displayProductMenu() {
    printf("\n======================== FIRA SHOPING ========================\n");
    printf("\n  * * * * * * * * * *  SELAMAT DATANG  * * * * * * * * * *\n");
	printf("!!PRODUK TERBARU DI TAHUN 2024!!\n");
    printf("1. Foundation\n");
    printf("2. Concealer\n");
    printf("3. Loose Powder\n");
    printf("4. Blush On\n");
    printf("5. Lip Cream\n");
    printf("6. Keluar\n");
    printf("==============================================================\n");
}

// Fungsi untuk menampilkan menu shade
void displayShadeMenu() {
    printf("\nSilakan pilih shade (01-06): ");
}

// Fungsi untuk menampilkan menu metode pembayaran
void displayPaymentMenu() {
    printf("\nSilakan pilih metode pembayaran:\n");
    printf("1. COD (Bayar Tunai saat Barang Sampai)\n");
    printf("2. Transfer Bank\n");
    printf("3. OVO\n");
}

// Fungsi untuk menampilkan menu pemilihan bank
void displayBankMenu() {
    printf("\nSilakan pilih bank:\n");
    printf("1. Bank BRI\n");
    printf("2. Bank BNI\n");
    printf("3. Bank Mandiri\n");
    printf("4. Bank Jatim\n");
}

int main() {
    int choice;
    int shadeChoice;
    int paymentChoice;
    int bankChoice;

    do {
        // Menampilkan menu produk
        displayProductMenu();

        // Minta pengguna untuk memilih produk
        printf("Silakan pilih produk (1-6): ");
        scanf("%d", &choice);

        if (choice >= 1 && choice <= 5) {
            // Menampilkan menu shade
            displayShadeMenu();

            // Minta pengguna untuk memilih shade
            scanf("%d", &shadeChoice);

            // Menampilkan pesan bahwa produk berhasil dipilih
            printf("\n===== Produk berhasil dipilih =====\n");

            // Menampilkan menu metode pembayaran
            displayPaymentMenu();

            // Minta pengguna untuk memilih metode pembayaran
            printf("Silakan pilih metode pembayaran (1-3): ");
            scanf("%d", &paymentChoice);

            if (paymentChoice == 2) {
                // Jika metode pembayaran adalah "Transfer Bank"
                // Menampilkan menu pemilihan bank
                displayBankMenu();

                // Minta pengguna untuk memilih bank
                printf("Silakan pilih bank (1-4): ");
                scanf("%d", &bankChoice);
            }

            // Menampilkan pesan bahwa produk berhasil dibayar
            printf("\n===== Selamat! Produk berhasil dibayar. =====\n");

            if (paymentChoice == 2) {
                // Jika metode pembayaran adalah "Transfer Bank"
                // Menampilkan pesan memilih bank
                printf("Anda memilih transfer via ");
                switch (bankChoice) {
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

            // Menampilkan pesan bahwa produk sedang dalam proses pengemasan
            printf("Produk sedang dalam proses pengemasan...\n");

            // Menambahkan jeda sejenak sebelum kembali ke menu utama
            printf("\n==============================================================\n");
            printf("Tekan Enter untuk kembali ke menu utama...");
            getchar(); // Menangkap karakter Enter yang tidak terbaca sebelumnya
            getchar(); // Menangkap karakter Enter setelah user menekan Enter
        } else if (choice == 6) {
            printf("Terima kasih telah berbelanja di Fira Shoping. Sampai jumpa!\n");
        } else {
            printf("Pilihan tidak valid. Silakan pilih produk 1-6.\n");
        }

    } while (choice != 6); // Melakukan loop sampai pengguna memilih untuk keluar

    return 0;
}
