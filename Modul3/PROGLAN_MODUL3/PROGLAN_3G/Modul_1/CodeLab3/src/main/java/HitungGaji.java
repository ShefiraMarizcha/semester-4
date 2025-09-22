import java.text.NumberFormat;
import java.util.Locale;

public class HitungGaji {

    // Metode perhitungan gaji dengan langsung mengalikan jam kerja dengan gaji per jam
    public int perhitunganGaji(int jamKerja, int gajiPerJam) {
        return jamKerja * gajiPerJam;
    }

    public static void main(String[] args) {
        HitungGaji hitung = new HitungGaji();

        // Menghitung total gaji berdasarkan 40 jam kerja dan gaji per jam sebesar 250000
        int gajiTotal = hitung.perhitunganGaji(40, 250000);

        // Memformat hasil gaji menggunakan format mata uang Rupiah
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        System.out.println("Gaji karyawan dengan 40 jam kerja = " + formatRupiah.format(gajiTotal));
    }
}
