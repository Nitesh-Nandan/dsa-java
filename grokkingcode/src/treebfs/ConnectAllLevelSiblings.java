package treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllLevelSiblings {

    private static void connect(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode prev = null;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (prev != null) {
                prev.next = curr;
            }
            prev = curr;

            if (curr.left != null) {
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllLevelSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNode current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        /**
         * Traversal using 'next' pointer: 12 7 1 9 10 5
         */
    }
}
