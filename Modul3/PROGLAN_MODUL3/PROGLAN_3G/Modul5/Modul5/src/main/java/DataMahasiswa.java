import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class DataMahasiswa {

    static List<String> namaList = new ArrayList<>();
    static List<Mahasiswa> mahasiswaList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Program Input Data Mahasiswa");
        System.out.println("================================");

        while (true) {
            System.out.println("\nPilih opsi:");
            System.out.println("1. Input data mahasiswa");
            System.out.println("2. Simpan ke file dan keluar");
            System.out.print("Pilihan Anda: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan buffer

            if (pilihan == 1) {
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                if (namaList.contains(nama)) {
                    System.out.println("Nama sudah ada, silakan masukkan nama yang berbeda.");
                    continue;
                }

                System.out.print("Masukkan semester: ");
                String semester = scanner.nextLine();

                System.out.print("Masukkan mata kuliah: ");
                String mataKuliah = scanner.nextLine();

                Mahasiswa mahasiswa = new Mahasiswa(nama, semester, mataKuliah);
                mahasiswaList.add(mahasiswa);
                namaList.add(nama);

                System.out.println("Data berhasil ditambahkan!");
            } else if (pilihan == 2) {
                try {
                    simpanKeExcel(mahasiswaList);
                    System.out.println("Data berhasil disimpan ke file 'data_mahasiswa.xlsx'");
                } catch (IOException e) {
                    System.out.println("Terjadi kesalahan saat menyimpan file: " + e.getMessage());
                }
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }

    private static void simpanKeExcel(List<Mahasiswa> mahasiswaList) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data Mahasiswa");

        // Header
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Nama");
        headerRow.createCell(1).setCellValue("Semester");
        headerRow.createCell(2).setCellValue("Mata Kuliah");

        // Data rows
        int rowNum = 1;
        for (Mahasiswa mhs : mahasiswaList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(mhs.getNama());
            row.createCell(1).setCellValue(mhs.getSemester());
            row.createCell(2).setCellValue(mhs.getMataKuliah());
        }

        // Menyimpan ke file
        try (FileOutputStream fileOut = new FileOutputStream("data_mahasiswa.xlsx")) {
            workbook.write(fileOut);
        }

        workbook.close();
    }

    static class Mahasiswa {
        private String nama;
        private String semester;
        private String mataKuliah;

        public Mahasiswa(String nama, String semester, String mataKuliah) {
            this.nama = nama;
            this.semester = semester;
            this.mataKuliah = mataKuliah;
        }

        public String getNama() {
            return nama;
        }

        public String getSemester() {
            return semester;
        }

        public String getMataKuliah() {
            return mataKuliah;
        }
    }
}
