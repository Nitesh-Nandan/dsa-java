package treebfs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderAverage {

    static List<Double> findLevelAverages(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Double> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            double sum = 0;
            int count = queue.size();
            int itr = count;

            while (itr-- > 0) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            ans.add((sum / count));
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = findLevelAverages(root);
        System.out.print("Level averages are: " + result); // [12.0, 4.0, 6.5]
    }
}
