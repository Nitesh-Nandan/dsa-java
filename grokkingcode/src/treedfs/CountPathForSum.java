package treedfs;

public class CountPathForSum {
    public static int countPaths(TreeNode root, int sum) {
        if (root == null || sum < 0) {
            return 0;
        }
        if (sum == root.val && root.left == null && root.right == null) {
            return 1;
        } else {
            return countPaths(root.left, sum - root.val) + countPaths(root.right, sum - root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountPathForSum.countPaths(root, 11));
    }
}
