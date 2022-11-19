package treebfs;

public class MinimumDepthOfBinaryTree {

    static int minDepthOfTree(TreeNode root) {
        if (root == null) return 0;
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + minDepthOfTree(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + minDepthOfTree(root));
    }
}
