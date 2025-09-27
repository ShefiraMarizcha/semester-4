import java.util.Scanner;

public class BinaryTreeKeluarga {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--------------Kepala Keluarga---------------");
        KeluargaNode root = inputAnggota("Kepala Keluarga");

        tambahAnak(root);

        System.out.println("\nVisualisasi Pohon Keluarga:");
        tampilkanTree(root, "", true);

        System.out.println("\nPreOrder Traversal:");
        preOrder(root);
        System.out.println("\nInOrder Traversal:");
        inOrder(root);
        System.out.println("\nPostOrder Traversal:");
        postOrder(root);
    }

    static KeluargaNode inputAnggota(String posisi) {
        System.out.print("Nama " + posisi + ": ");
        String nama = scanner.nextLine();
        System.out.print("Jenis Kelamin (Pria/Wanita): ");
        String jk = scanner.nextLine();
        System.out.print("Relasi: ");
        String relasi = scanner.nextLine();
        return new KeluargaNode(nama, jk, relasi);
    }

    static void tambahAnak(KeluargaNode parent) {
        System.out.print("Apakah " + parent.nama + " memiliki anak? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Masukkan Anak ke-1 dari " + parent.nama);
            parent.kiri = inputAnggota("Anak ke-1");
            tambahAnak(parent.kiri);

            System.out.print("Apakah " + parent.nama + " memiliki anak ke-2? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.println("Masukkan Anak ke-2 dari " + parent.nama);
                parent.kanan = inputAnggota("Anak ke-2");
                tambahAnak(parent.kanan);
            }
        }
    }

    static void tampilkanTree(KeluargaNode node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("└──");
                indent += "   ";
            } else {
                System.out.print("├──");
                indent += "|  ";
            }
            System.out.println(node.nama + " (" + node.relasi + ")");
            tampilkanTree(node.kiri, indent, false);
            tampilkanTree(node.kanan, indent, true);
        }
    }

    static void preOrder(KeluargaNode node) {
        if (node != null) {
            System.out.print("[" + node.nama + "] ");
            preOrder(node.kiri);
            preOrder(node.kanan);
        }
    }

    static void inOrder(KeluargaNode node) {
        if (node != null) {
            inOrder(node.kiri);
            System.out.print("[" + node.nama + "] ");
            inOrder(node.kanan);
        }
    }

    static void postOrder(KeluargaNode node) {
        if (node != null) {
            postOrder(node.kiri);
            postOrder(node.kanan);
            System.out.print("[" + node.nama + "] ");
        }
    }
}
