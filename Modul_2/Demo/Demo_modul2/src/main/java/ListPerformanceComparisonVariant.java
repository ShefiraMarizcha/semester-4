import java.util.*;

public class ListPerformanceComparisonVariant {
    public static void main(String[] args) {
        final int SIZE = 100000;
        //disini juga sudah memenuhi ketentuan untuk isi list sebanyak 100.000 elemen
        Random random = new Random();

        // untuk poin 1 yaitu inisialisasi list besar, disini pakai  interface List
        // yang memuat 2 list, array list sama linked list
        List<Integer> arrayList = new ArrayList<>(SIZE);
        List<Integer> linkedList = new LinkedList<>();

        //untuk bagian ini melakuakn looping untuk ngisi kedua elemen pakai 100.00 elemen acak
        for (int i = 0; i < SIZE; i++) { // i < size ini kondisi looping selama i ini kurang dari 100.000
            //ini inisialisais variabel i dimulai dari 0, i++ ini inkremen, jadi tiap iterasi i nya nambah 1
            int value = random.nextInt(); // bialnagn bulat acak
            arrayList.add(value); // nambahin angka acak ke arraylist
            linkedList.add(value); // nambahkan angka acak ke linkedlist
            // jadi tiap loop 1 angka acak bakal di tambahin di kedua list
        }

        // ketentuan no. 2, pengukuran operasi, disini ada 3 yaitu;
        System.out.println("=== Penyisipan di Awal ===");
        measureTime(() -> arrayList.add(0, 99999), "ArrayList - Penyisipan");
        measureTime(() -> linkedList.add(0, 99999), "LinkedList - Penyisipan");
        // untuk yang pertama itu penyisipan diawal list atau di index 0, jadi ngitung waktu yg dibutuhin buat nyisipin elemen ke indesk 0/ posisi awal.
        //pakai metod measureTime, nah metod ini tuh buat ngukur waktu eksekusinya



        System.out.println("\n=== Penghapusan di Tengah ===");
        measureTime(() -> arrayList.remove(SIZE / 2), "ArrayList - Penghapusan");
        measureTime(() -> linkedList.remove(SIZE / 2), "LinkedList - Penghapusan");
        /*untuk yang ke 2 itu pengahupsan elemen di tengah list, jadi disini bakal ngukur waktu yg diperlukan buat hapus elemen
        yang posisinya di tengah dari arraylist dan linked list.
        nah size / 2 ini indeks elmen di tengah list
        linkedList.remove(SIZE / 2) = ini hapus elemen tengah linked list
         measureTime(() buat ngukur waktu eksekusi
         */


        System.out.println("\n=== Akses Elemen Secara Acak ===");
        measureRandomAccess(arrayList, "ArrayList", SIZE);
        measureRandomAccess(linkedList, "LinkedList", SIZE);
    }
        /* untuk yang ke 3 yaitu akses elemen secara acak, bagian ini untuk ngukur waktu akses elemen acak di arraylist dan
        linked list. pakai metod measureRandomAccess untuk ngukur waktu akses dari 100.000 elemen di kedua loist
        (list pertama yg di uji, list type ini label untuk nampilin hasil, size ini ukuran list yaitu 100.000 elemem)

         */
    private static void measureTime(Runnable operation, String description) {
        long startTime = System.nanoTime(); // ini waktu sebelum operasi perhitumgannya di mulai, pakai System.nanoTime()
                                            // karna lebih presisi dari pada pake currenttimemillis
        operation.run(); // ini bagian eksekusi kode nya
        long endTime = System.nanoTime(); // ini catatan waktu setelah operasi selesai
        System.out.println(description + " - Waktu: " + (endTime - startTime) + " ns");
        // bagian ini untuk ngitung selisih waktunya dan menampilkan hasil atau bagian untuk cetak hasil waktu eksekusinya
        //ns ini nanosekon
    }

    //ini implementasi measureRandomAccess
    private static void measureRandomAccess(List<Integer> list, String listType, int size) {
        Random random = new Random(); // buat ngasilin angka acak
        long startTime = System.nanoTime(); // mencatat waktu sebelum akses elemen, pakai  System.nanoTime() karna buat ngitung durasii dalam nanosekon
        for (int i = 0; i < 1000; i++) {
            list.get(random.nextInt(size)); // bagian ini ngasilin indeks acak antara 0 sampe size -1
            //bagian list.get ini untuk akses elemen yg dipilih acak
        }
        long endTime = System.nanoTime(); // mencatat waktu setelah akses acak selesai
        System.out.println(listType + " - Waktu Akses Acak: " + (endTime - startTime) + " ns");
        // ini akan menampilkan output , total waktu eksekusinya (endTime - startTime),
    }
}

/*
Analisis:
1. Penyisipan di awal:
   - ArrayList lebih lambat 509500 ns, karena dia harus geser elemen yang udah ada ke kanan buat ngasih ruang untuk lemen baru di indeks yang pertama atau 0
   - LinkedList lebih cepat 47100 ns, karena cuma perlu memperbarui node, jadi gapake di geser kayak arraylist, ini lebih efisien

2. Penghapusan di tengah:
   - ArrayList 43100 ns, lebih cepat soalnya walau pake pergeseran setelah di hapus, tapi dia bisa langsung akses indeks yang ada di tenagh
   - LinkedList 1215600 ns, lebih lambat soalnya kalau hapus elemen tengah dia harus nyusurin satu-satu nodenya sampe ketemu yang mau di hapus

3. Akses acak:
   - ArrayList 596600 ns, lebih cepat soalnya  akses secara acak bisa langsung pake indeks
   - LinkedList 102256700 ns, lebih lambat soalnya harus jelajahin elemen satu persatu dari awal untuk ngambil indeks tertentu
*/
