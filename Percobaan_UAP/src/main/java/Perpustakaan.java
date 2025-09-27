import java.util.ArrayList;

public class Perpustakaan {
    private static boolean buku;

    public static void main(String[] args) {
        ArrayList<String> daftarBuku = new ArrayList<>();

        daftarBuku.add("aaa");
        daftarBuku.add("iii");
        daftarBuku.add("uuu");
        

        daftarBuku.remove(2);

        System.out.println("Daftar Buku");
        for (String buku : daftarBuku); {
            System.out.println(buku);
        }

        System.out.println("total jumlah buku" + daftarBuku.size());
    }

    {

    }
}