package treebfs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

    static List<List<Integer>> zigZagTraverse(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int dir = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int itr = queue.size();
            List<Integer> list = new LinkedList<>();
            while (itr-- > 0) {
                TreeNode cur = queue.poll();
                if (dir == 0) {
                    list.add(cur.val);
                } else {
                    list.add(0, cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ans.add(list);
            dir = dir ^ 1;
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
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = zigZagTraverse(root);
        System.out.println("Zigzag traversal: " + result); // [[12], [1, 7], [9, 10, 5], [17, 20]]
    }
}
