import java.util.HashMap;
import java.util.Map;

/**
 * Aplikasi Nota Pemesanan Makanan di Restoran
 * Menyediakan fitur untuk menambah item menu, memasukkan jumlah pesanan,
 * menghitung total harga, dan menampilkan nota pesanan.
 */
public class RestaurantOrderApp {

    /**
     * Kelas MenuItem untuk merepresentasikan item menu makanan atau minuman.
     */
    static class MenuItem {
        private String nama;
        private double harga;

        public MenuItem(String nama, double harga) {
            this.nama = nama;
            this.harga = harga;
        }

        public String getNama() {
            return nama;
        }

        public double getHarga() {
            return harga;
        }
    }

    /**
     * Kelas Order untuk mengatur item yang dipesan dan menghitung total harga.
     */
    static class Order {
        private Map<MenuItem, Integer> pesanan;

        public Order() {
            pesanan = new HashMap<>();
        }

        /**
         * Menambahkan item menu ke dalam pesanan dengan jumlah yang ditentukan.
         * @param item  Item menu yang dipesan.
         * @param jumlah Jumlah item yang dipesan.
         */
        public void tambahItem(MenuItem item, int jumlah) {
            pesanan.put(item, pesanan.getOrDefault(item, 0) + jumlah);
        }

        /**
         * Menghitung total harga dari seluruh item yang dipesan.
         * @return Total harga dari pesanan.
         */
        public double hitungTotal() {
            double total = 0;
            for (Map.Entry<MenuItem, Integer> entry : pesanan.entrySet()) {
                total += entry.getKey().getHarga() * entry.getValue();
            }
            return total;
        }

        public Map<MenuItem, Integer> getPesanan() {
            return pesanan;
        }
    }

    /**
     * Kelas OrderReceipt untuk menampilkan nota pemesanan makanan.
     */
    static class OrderReceipt {
        private Order order;

        public OrderReceipt(Order order) {
            this.order = order;
        }

        /**
         * Menampilkan nota pemesanan ke layar dengan rincian item, jumlah, dan total harga.
         */
        public void tampilkanNota() {
            System.out.println("====== Nota Pemesanan ======");
            for (Map.Entry<MenuItem, Integer> entry : order.getPesanan().entrySet()) {
                MenuItem item = entry.getKey();
                int jumlah = entry.getValue();
                System.out.printf("%-20s x %d = Rp. %.2f\n", item.getNama(), jumlah, item.getHarga() * jumlah);
            }
            System.out.println("---------------------------");
            System.out.printf("Total Bayar: Rp. %.2f\n", order.hitungTotal());
            System.out.println("===========================");
        }
    }

    /**
     * Method utama untuk menjalankan program dan menguji kelas-kelas dalam aplikasi ini.
     */
    public static void main(String[] args) {
        // Membuat item menu
        MenuItem nasiGoreng = new MenuItem("Nasi Goreng", 25000);
        MenuItem sateAyam = new MenuItem("Sate Ayam", 30000);
        MenuItem esTeh = new MenuItem("Es Teh", 5000);

        // Membuat pesanan
        Order order = new Order();
        order.tambahItem(nasiGoreng, 2);
        order.tambahItem(sateAyam, 1);
        order.tambahItem(esTeh, 3);

        // Menampilkan nota pemesanan
        OrderReceipt nota = new OrderReceipt(order);
        nota.tampilkanNota();
    }
}
