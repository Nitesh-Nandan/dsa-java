package treebfs;

class ConnectLevelOrderSiblings {
    public static void connect(TreeNode root) {
       return;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();

        /**
         * Level order traversal using 'next' pointer:
         * 12
         * 7 1
         * 9 10 5
         */
    }
}
