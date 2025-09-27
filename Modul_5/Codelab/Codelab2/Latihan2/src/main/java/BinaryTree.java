class BinaryTree {
    public Node root;

    public void newNode(int data) {
        root = insert(root, new Node(data));
    }

    private Node insert(Node root, Node newData) {
        if (root == null) {
            return newData;
        }
        if (newData.data < root.data) {
            root.left = insert(root.left, newData);
        } else {
            root.right = insert(root.right, newData);
        }
        return root;
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] values = {50, 30, 70, 20, 40, 60, 80, 35, 65};

        for (int value : values) {
            tree.newNode(value);
        }

        System.out.println("Pre Order: ");
        tree.preorder(tree.root);

        System.out.println("\nIn Order: ");
        tree.inorder(tree.root);

        System.out.println("\nPost Order: ");
        tree.postorder(tree.root);
    }
}