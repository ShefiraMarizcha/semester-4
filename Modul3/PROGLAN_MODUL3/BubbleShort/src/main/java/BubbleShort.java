public class BubbleShort {
    public static void bubbleSort(int[] arr) {
        int i = 1, j, n = arr.length;
        int temp;

        while (i < n) {
            j = n - 1;
            while (j >= i) {
                if (arr[j - 1] > arr[j]) {
                    // Tukar elemen jika elemen sebelumnya lebih besar dari elemen saat ini
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                j = j - 1;
            }
            i = i + 1;
        }
    }
    public static void tampil(int data[]) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
class MainBubble {
    public static void main(String[] args) {
        // Gunakan data sebelumnya {5, 6, 3, 1, 2}
        int A[] = {5, 6, 3, 1, 2};

        // Tampilkan array sebelum diurutkan
        BubbleShort.tampil(A);

        // Urutkan array dengan bubbleSort
        BubbleShort.bubbleSort(A);

        // Tampilkan array setelah diurutkan
        BubbleShort.tampil(A);
    }
}
