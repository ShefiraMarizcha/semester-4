import java.util.Scanner;

class Node {
    int value;
    Node link;

    public Node(int value) {
        this.value = value;
        this.link = null;
    }
}

class LinkedList {
    Node head;

    // Menambahkan node ke dalam linked list
    public void addNode(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

    // Menampilkan isi linked list
    public void display() {
        Node temp = head;
        System.out.println("Isi LinkedList:");
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.link;
        }
        System.out.println("null");
    }

    // Mengakses elemen kedua
    public void displaySecondElement() {
        if (head != null && head.link != null) {
            System.out.println("Elemen kedua: " + head.link.value);
        } else {
            System.out.println("Tidak ada elemen kedua.");
        }
    }

    // Mengubah nilai elemen pertama
    public void updateFirstElement(int newValue) {
        if (head != null) {
            head.value = newValue;
        }
    }

    // Menghapus elemen kedua
    public void removeSecondElement() {
        if (head != null && head.link != null) {
            head.link = head.link.link;
        } else {
            System.out.println("Tidak bisa menghapus elemen kedua karena tidak ada atau hanya satu elemen.");
        }
    }
}

class LinkedListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        // Input tiga nilai untuk node
        System.out.print("Masukkan nilai node pertama: ");
        int first = scanner.nextInt();
        list.addNode(first);

        System.out.print("Masukkan nilai node kedua: ");
        int second = scanner.nextInt();
        list.addNode(second);

        System.out.print("Masukkan nilai node ketiga: ");
        int third = scanner.nextInt();
        list.addNode(third);

        // Menampilkan isi awal LinkedList
        list.display();

        // Menampilkan elemen kedua
        list.displaySecondElement();

        // Mengubah nilai elemen pertama
        System.out.print("Masukkan nilai baru untuk elemen pertama: ");
        int newFirstValue = scanner.nextInt();
        list.updateFirstElement(newFirstValue);
        System.out.println("Isi LinkedList setelah perubahan pada elemen pertama:");
        list.display();

        // Menanyakan apakah user ingin menghapus elemen kedua
        System.out.print("Apakah ingin menghapus elemen kedua? (y/n): ");
        char choice = scanner.next().charAt(0);
        if (choice == 'y' || choice == 'Y') {
            list.removeSecondElement();
            System.out.println("Isi LinkedList setelah elemen kedua dihapus:");
            list.display();
        } else {
            System.out.println("Elemen kedua tidak dihapus.");
        }

        scanner.close();
    }
}
