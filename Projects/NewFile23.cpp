#include <stdio.h>

// Fungsi untuk menampilkan menu produk
void displayProductMenu() {
    printf("\nSelamat datang di Fira Shoping!\n");
    printf("1. Foundation\n");
    printf("2. Concealer\n");
    printf("3. Loose Powder\n");
    printf("4. Blush On\n");
    printf("5. Lip Cream\n");
    printf("6. Keluar\n");
}

// Fungsi untuk menampilkan menu shade
void displayShadeMenu() {
    printf("\nSilakan pilih shade (01-06): ");
}

// Fungsi untuk menampilkan menu metode pembayaran
void displayPaymentMenu() {
    printf("\nSilakan pilih metode pembayaran:\n");
    printf("1. COD\n");
    printf("2. Transfer Bank\n");
    printf("3. OVO\n");
}

int main() {
    int choice;
    int shadeChoice;
    int paymentChoice;

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
            printf("\nProduk berhasil dipilih. ");

            // Menampilkan menu metode pembayaran
            displayPaymentMenu();

            // Minta pengguna untuk memilih metode pembayaran
            printf("Silakan pilih metode pembayaran (1-3): ");
            scanf("%d", &paymentChoice);

            // Menampilkan pesan bahwa produk berhasil dibayar
            printf("\nSelamat! Produk berhasil dibayar.\n");

            // Menampilkan pesan bahwa produk sedang dalam proses pengemasan
            printf("Produk sedang dalam proses pengemasan.\n");
        } else if (choice == 6) {
            printf("Terima kasih telah berbelanja di Fira Shoping. Sampai jumpa!\n");
        } else {
            printf("Pilihan tidak valid. Silakan pilih produk 1-6.\n");
        }

    } while (choice != 6); // Melakukan loop sampai pengguna memilih untuk keluar

    return 0;
}
