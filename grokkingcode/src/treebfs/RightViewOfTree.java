package treebfs;

import java.util.LinkedList;
import java.util.List;

public class RightViewOfTree {
    private static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> ans = new LinkedList<>();
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewOfTree.traverse(root); // 12 1 5 3
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }

    }
}
