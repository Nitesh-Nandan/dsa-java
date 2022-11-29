package backtracking;

import util.TestCaseUtil;

class HouseNode {
    int withRobbery = 0;
    int withoutRobbery = 0;
}

public class HouseRobberyInBinaryTree {
    public static int rob(BinaryTreeNode root) {
        HouseNode ans = robHelper(root);
        return Math.max(ans.withoutRobbery, ans.withRobbery);
    }

    public static HouseNode robHelper(BinaryTreeNode root) {
        if (root == null) return new HouseNode();
        HouseNode left = robHelper(root.left);
        HouseNode right = robHelper(root.right);

        HouseNode curr = new HouseNode();
        curr.withRobbery = root.data + left.withoutRobbery + right.withoutRobbery;
        curr.withoutRobbery = Math.max(left.withoutRobbery, left.withRobbery) + Math.max(right.withoutRobbery, right.withRobbery);

        return curr;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        BinaryTreeNode root = new BinaryTreeNode(2);
        root.left = new BinaryTreeNode(7);
        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(6);
        root.left.right.left = new BinaryTreeNode(5);
        root.left.right.right = new BinaryTreeNode(11);

        root.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(8);
        root.right.right.left = new BinaryTreeNode(4);

        TestCaseUtil.test(32, rob(root), 1);
    }

    static void test2() {
        BinaryTreeNode root = new BinaryTreeNode(2);
        root.left = new BinaryTreeNode(7);
        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(6);
        root.left.right.left = new BinaryTreeNode(5);
        root.left.right.right = new BinaryTreeNode(11);

        root.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(19);
        root.right.right.left = new BinaryTreeNode(4);

        TestCaseUtil.test(42, rob(root), 2);
    }

    static void test3() {
        BinaryTreeNode root = new BinaryTreeNode(2000);
        root.left = new BinaryTreeNode(10);
        root.left.left = new BinaryTreeNode(10);
        root.left.left.left = new BinaryTreeNode(1000);
        root.left.right = new BinaryTreeNode(10);
        root.left.right.left = new BinaryTreeNode(2);
        root.left.right.right = new BinaryTreeNode(1000);

        root.right = new BinaryTreeNode(2);
        root.right.left = new BinaryTreeNode(2);
        root.right.left.left = new BinaryTreeNode(1000);
        root.right.left.right = new BinaryTreeNode(2);
        root.right.left.right.left = new BinaryTreeNode(1000);

        TestCaseUtil.test(6002, rob(root), 3);
    }
}