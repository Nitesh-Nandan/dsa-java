package treedfs;

public class BinaryTreePathSum {
    private static boolean hasPath(TreeNode root, int sum) {
       return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + BinaryTreePathSum.hasPath(root, 23)); // true
        System.out.println("Tree has path: " + BinaryTreePathSum.hasPath(root, 16)); // false
    }

}
