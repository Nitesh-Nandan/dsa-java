package treedfs;

import java.util.ArrayList;
import java.util.List;

public class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        List<Integer> pathSumList = new ArrayList<>();
        helper(root, pathSumList, 0);

        int ans = 0;
        for (Integer val : pathSumList) {
            ans += val;
        }
        return ans;
    }

    static void helper(TreeNode root, List<Integer> pathSumList, int sum) {
        if (root == null) return;
        sum = (sum * 10) + root.val;
        if (root.left == null && root.right == null) {
            pathSumList.add(sum);
        } else {
            helper(root.left, pathSumList, sum);
            helper(root.right, pathSumList, sum);
        }
    }

    public static int findSumOfPathNumbers2(TreeNode root) {
        return helper2(root, 0);
    }

    static int helper2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = 10 * sum + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return helper2(root.left, sum) + helper2(root.right, sum);
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
