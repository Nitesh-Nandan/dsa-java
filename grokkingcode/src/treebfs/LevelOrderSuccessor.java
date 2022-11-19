package treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

    static TreeNode findSuccessor(TreeNode treeNode, int val) {
        if(treeNode == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr.left != null) {
                queue.offer(curr.left);
            }
            if(curr.right != null) {
                queue.offer(curr.right);
            }
            if(curr.val == val) {
                break;
            }
        }

        return queue.peek();
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 3); // 4
        if (result != null)
            System.out.println(result.val + " ");

        root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        result = LevelOrderSuccessor.findSuccessor(root, 9); // 10
        if (result != null)
            System.out.println(result.val + " ");

        result = LevelOrderSuccessor.findSuccessor(root, 12); // 7
        if (result != null)
            System.out.println(result.val + " ");
    }
}
