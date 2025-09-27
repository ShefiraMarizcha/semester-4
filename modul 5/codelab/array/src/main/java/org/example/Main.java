package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class MahasiswaInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> daftarMahasiswa = new ArrayList<>();
        int counter = 1;

        while (true) {
            System.out.print("Masukkan nama ke-" + counter + ": ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("selesai")) {
                break;
            }

            try {
                if (input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Nama tidak boleh kosong!");
                } else {
                    daftarMahasiswa.add(input);
                    counter++;
                    if (counter > 5) {
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Daftar mahasiswa yang diinputkan:");
        for (String nama : daftarMahasiswa) {
            System.out.println("- " + nama);
        }

        scanner.close();
    }
}
