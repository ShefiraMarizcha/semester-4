import java.util.HashMap;
import java.util.Scanner;

public class NilaiMahasiswa {
    public static void main(String[] args) {
        HashMap<String, Integer> dataNilai = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Input 3 data mahasiswa
        for (int i = 1; i <= 3; i++) {
            System.out.print("Masukkan NIM mahasiswa ke-" + i + ": ");
            String nim = scanner.nextLine();
            System.out.print("Masukkan nilai mahasiswa ke-" + i + ": ");
            int nilai = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline
            dataNilai.put(nim, nilai);
        }

        // Cari nilai berdasarkan NIM
        System.out.print("Masukkan NIM yang ingin dicari: ");
        String nimCari = scanner.nextLine();

        if (dataNilai.containsKey(nimCari)) {
            System.out.println("Nilai mahasiswa dengan NIM " + nimCari + ": " + dataNilai.get(nimCari));
        } else {
            System.out.println("Data tidak ditemukan");
        }

        scanner.close();
    }
}
