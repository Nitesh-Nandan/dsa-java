package treedfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathForASum {
    private static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new LinkedList<>();
        findPathsRecursive(root, sum, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath,
                                           List<List<Integer>> allPaths) {
        if (currentNode == null) {
            return;
        }
        currentPath.add(currentNode.val);

        if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
            findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
        }
        currentPath.remove(currentPath.size() - 1);
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
