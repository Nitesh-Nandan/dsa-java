package treedfs;

import java.util.List;

public class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
       return -1;
    }

    static void helper(TreeNode root, List<Integer> pathSumList, int sum) {

    }

    public static int findSumOfPathNumbers2(TreeNode root) {
        return helper2(root, 0);
    }

    static int helper2(TreeNode root, int sum) {
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root)); // 332
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers2(root)); // 332
    }
}
