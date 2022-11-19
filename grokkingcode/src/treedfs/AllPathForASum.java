package treedfs;

import java.util.Collections;
import java.util.List;

public class AllPathForASum {
    private static List<List<Integer>> findPaths(TreeNode root, int sum) {
        return Collections.emptyList();
    }

    private static void findPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath,
                                           List<List<Integer>> allPaths) {
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result); // [[12, 7, 4], [12, 1, 10]]
    }
}
