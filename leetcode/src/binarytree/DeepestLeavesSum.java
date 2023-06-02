package binarytree;

public class DeepestLeavesSum {
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        getSum(root, 1, getHeight(root));
        return sum;
    }

    private int getHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private void getSum(TreeNode root, int level, int maxLevel) {
        if(root == null) {
            return;
        }

        if(level == maxLevel) {
            sum += root.val;
        }
        getSum(root.left, level+1, maxLevel);
        getSum(root.left, level+1, maxLevel);
    }

    public static void main(String[] args) {

    }
}
