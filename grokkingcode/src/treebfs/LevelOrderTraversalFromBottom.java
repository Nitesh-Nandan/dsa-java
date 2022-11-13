package treebfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalFromBottom {

    static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int itr = queue.size();
            List<Integer> level = new LinkedList<>();
            while (itr-- > 0) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if(curr.left != null) {
                    queue.offer(curr.left);
                }
                if(curr.right!=null) {
                    queue.offer(curr.right);
                }
            }
            ans.add(0, level);
        }
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
