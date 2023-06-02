package binarytree;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root);

    }

    private int helper(TreeNode root) {
        if(root == null) {
            return 1000000;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        return 1 + Math.min(left, right);
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
//        [2,null,3,null,4,null,5,null,6]
        TreeNode treeNode = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(5);
        treeNode.right.right.right.right = new TreeNode(6);
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(treeNode));
    }
}
