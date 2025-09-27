#include <stdio.h>

void displayProductMenu() {
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

void displayShadeMenu() {
    printf("\nSilakan pilih shade (01-06): ");
}

void displayPaymentMenu() {
    printf("\n------------------------------------------------------------\n");
    printf("|                   METODE PEMBAYARAN                       |\n");
    printf("| 1. COD (Bayar Tunai saat Barang Sampai)                   |\n");
    printf("| 2. Transfer Bank                                          |\n");
    printf("| 3. OVO                                                    |\n");
    printf("------------------------------------------------------------\n");
}

void displayBankMenu() {
    printf("\n------------------------------------------------------------\n");
    printf("|                      PILIH BANK                           |\n");
    printf("| 1. Bank BRI                                               |\n");
    printf("| 2. Bank BNI                                               |\n");
    printf("| 3. Bank Mandiri                                           |\n");
    printf("| 4. Bank Jatim                                             |\n");
    printf("------------------------------------------------------------\n");
}

int main() {
    int choice;
    int shadeChoice;
    int paymentChoice;
    int bankChoice;

    do {
        displayProductMenu();
        printf("Silakan pilih produk (1-6): ");
        scanf("%d", &choice);

        if (choice >= 1 && choice <= 5) {
            displayShadeMenu();
            scanf("%d", &shadeChoice);
            printf("\n------------------Produk berhasil dipilih-------------------\n");

            displayPaymentMenu();
            printf("Silakan pilih metode pembayaran (1-3): ");
            scanf("%d", &paymentChoice);

            if (paymentChoice == 2) {
                displayBankMenu();
                printf("Silakan pilih bank (1-4): ");
                scanf("%d", &bankChoice);
            }

              printf("\n-------------Selamat produk berhasil di bayar---------------\n");

            if (paymentChoice == 2) {
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

            printf("Produk sedang dalam proses pengemasan...\n");

            printf("\n************************************************************\n");
            printf("Tekan Enter untuk kembali ke menu utama...");
            getchar();
            getchar();
        } else if (choice == 6) {
            printf("Terima kasih telah berbelanja di Fira Shoping. Sampai jumpa!\n");
        } else {
            printf("Pilihan tidak valid. Silakan pilih produk 1-6.\n");
        }

    } while (choice != 6);

    return 0;
}
