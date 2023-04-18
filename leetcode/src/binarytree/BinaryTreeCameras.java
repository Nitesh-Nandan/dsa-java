package binarytree;

public class BinaryTreeCameras {
    public static int camera = 0;

    public static int minCameraCover(TreeNode root) {
        if (helper(root) == -1) {
            camera++;
        }
        return camera;
    }

    public static int helper(TreeNode root) {
        if (root == null) return 1;

        int left = helper(root.left);
        int right = helper(root.right);

        if (left == -1 || right == -1) {
            camera++;
            return 0;
        }

        if (left == 0 || right == 0) {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(0);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.left.left = new TreeNode(0);
        treeNode.left.left.left.right = new TreeNode(0);

        System.out.println(minCameraCover(treeNode));
    }
}
