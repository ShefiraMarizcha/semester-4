public class BinaryTree {
    public Node root;

    public BinaryTree() {
        root = null;
    }

    // Menambahkan root ke tree
    public void addRoot(int data) {
        root = new Node(data);
    }

    // Traversal PreOrder (Root -> Left -> Right)
    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Traversal InOrder (Left -> Root -> Right)
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    // Traversal PostOrder (Left -> Right -> Root)
    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Main Method untuk menjalankan program
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Membuat struktur tree
        tree.addRoot(73); // Root
        tree.root.left = new Node(14);
        tree.root.right = new Node(91);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(62);
        tree.root.right.left = new Node(28);

        // Menampilkan hasil traversal
        System.out.print("\nPreOrder: ");
        tree.preorder(tree.root);

        System.out.print("\nInOrder: ");
        tree.inOrder(tree.root);

        System.out.print("\nPostOrder: ");
        tree.postorder(tree.root);
    }
}