package treebfs;

import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversalFromBottom {

    static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = traverse(root);
        System.out.println("Reverse level order traversal: " + result); // [[9, 10, 5], [7, 1], [12]]
    }
}
