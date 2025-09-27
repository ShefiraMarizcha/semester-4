public class BinaryTree {
    public Node root;
    public BinaryTree() {
        root = null;
    }
    // Menambahkan root ke tree
    public void addRoot(int data) {
        root new Node(data);
    }
    // Traversal PreOrder (Root -> Left -> Right)
    public void preorder (Node node) {
        if (node != null) {
            System.out.print(node.data + ");
                    preorder(node.left);
            preorder(node.right);
        }
    }