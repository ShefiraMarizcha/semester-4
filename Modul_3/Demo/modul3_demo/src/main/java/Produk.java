import java.util.Scanner;


class Produk {
    String id;
    String nama;
    //konstrktr
    public Produk(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }
}


class AntrianPengiriman {
    private Produk[] queue;
    private int front;      // Indeks 1 msk
    private int rear;       // back
    private int size;       // max
    private int jumlah;


    public AntrianPengiriman(int kapasitas) {
        queue = new Produk[kapasitas];
        size = kapasitas;
        front = 0;
        rear = -1;
        jumlah = 0;
    }

    // full? y / N
    public boolean penuh() {
        return jumlah == size;
    }

    // cek 0
    public boolean kosong() {
        return jumlah == 0;
    }


    public void tambahProduk(Produk p) {
        if (penuh()) {
            System.out.println("Antrian pengiriman penuh. Tidak bisa menambah produk lagi.");
        } else {

            rear = (rear + 1) % size;
            queue[rear] = p;
            jumlah++;
            System.out.println("Produk berhasil ditambahkan ke antrian.");
        }
    }


    public Produk kirimProduk() {
        if (kosong()) {
            System.out.println("Antrian kosong. Tidak ada produk yang bisa dikirim.");
            return null;
        } else {
            Produk dikirim = queue[front];
            front = (front + 1) % size;
            jumlah--;
            return dikirim;
        }
    }


    public void tampilkanAntrian() {
        if (kosong()) {
            System.out.println("Antrian kosong. Tidak ada produk yang menunggu pengiriman.");
        } else {
            System.out.println("Daftar Produk dalam Antrian Pengiriman:");
            for (int i = 0; i < jumlah; i++) {
                int index = (front + i) % size;
                System.out.println((i + 1) + ". ID: " + queue[index].id + ", Nama: " + queue[index].nama);
            }
        }
    }
}


class FiraBeautyStorePengiriman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        AntrianPengiriman antrian = new AntrianPengiriman(10);


        while (true) {
            System.out.println("\n=== Fira Beauty Store - Sistem Pengiriman ===");
            System.out.println("1. Tambah Produk ke Antrian");
            System.out.println("2. Tampilkan Antrian Produk");
            System.out.println("3. Kirim Produk");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:

                    System.out.print("Masukkan ID Produk: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Nama Produk: ");
                    String nama = scanner.nextLine();
                    Produk produkBaru = new Produk(id, nama);
                    antrian.tambahProduk(produkBaru);
                    break;

                case 2:

                    antrian.tampilkanAntrian();
                    break;

                case 3:

                    Produk dikirim = antrian.kirimProduk();
                    if (dikirim != null) {
                        System.out.println("Produk dikirim: ID = " + dikirim.id + ", Nama = " + dikirim.nama);
                    }
                    break;

                case 4:

                    System.out.println("Terima kasih telah menggunakan sistem pengiriman Fira Beauty Store.");
                    System.exit(0);

                default:

                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
