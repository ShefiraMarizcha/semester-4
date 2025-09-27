import java.util.*;

class Node {
    int value;
    Node link;

    public Node(int value) {
        this.value = value;
        this.link = null;
    }
}

class LinkedListExample {
    public static void main(String[] args) {
        // Membuat simpul pertama dengan nilai 8
        Node start = new Node(8);

        // Menambahkan simpul kedua dengan nilai 12 dan menghubungkannya ke simpul pertama
        Node middle = new Node(12);
        start.link = middle;

        // Menambahkan simpul ketiga dengan nilai 20 dan menghubungkannya ke simpul kedua
        Node end = new Node(20);
        middle.link = end;

        // Menampilkan isi LinkedList
        System.out.println("Isi LinkedList:");
        Node pointer = start;
        while (pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.link;
        }

        // Mengakses elemen kedua
        System.out.println("Elemen kedua: " + start.link.value);

        // Mengubah nilai elemen pertama menjadi 30
        start.value = 30;
        System.out.println("Isi LinkedList setelah perubahan pada elemen pertama:");
        pointer = start;
        while (pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.link;
        }

        // Menghapus elemen kedua dengan menghubungkan langsung ke elemen ketiga
        start.link = start.link.link;
        System.out.println("Isi LinkedList setelah elemen kedua dihapus:");
        pointer = start;
        while (pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.link;
        }
    }
}
