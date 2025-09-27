import java.io.InputStream;

public class Balok extends BangunRuang {
    private final MyScanner myScanner = new MyScanner();
    private double panjang;
    private double lebar;
    private double tinggi;

    public Balok(String nama) {
        super(nama);
    }

    @Override
    public void inputNilai() {
        printLine("Input panjang: ");
        panjang = myScanner.nextMyDouble();
        printLine("Input lebar: ");
        lebar = myScanner.nextMyDouble();
        printLine("Input tinggi: ");
        tinggi = myScanner.nextMyDouble();
    }

    @Override
    public void luasPermukaan() {
        double hasil = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
        printLine("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume() {
        double hasil = panjang * lebar * tinggi;
        printLine("Hasil volume: " + hasil);
    }

    private void printLine(String message) {
        System.out.print(message);
    }

    private static class MyScanner {
        private final   Scanner scanner = new Scanner(System.in);

        public double nextMyDouble() {
            return scanner.nextDouble();
        }

    }

    private static class Scanner {
        public Scanner(InputStream in) {

        }

        public double nextDouble() {
            return 0;
        }
    }
}

