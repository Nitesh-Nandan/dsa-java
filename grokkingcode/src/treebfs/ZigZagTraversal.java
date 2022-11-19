package treebfs;

import java.util.LinkedList;
import java.util.List;

public class ZigZagTraversal {

    static List<List<Integer>> zigZagTraverse(TreeNode root) {
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
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = zigZagTraverse(root);
        System.out.println("Zigzag traversal: " + result); // [[12], [1, 7], [9, 10, 5], [17, 20]]
    }
}
