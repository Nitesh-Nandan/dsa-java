package treebfs;

import java.util.Collections;
import java.util.List;

public class LevelOrderAverage {

    static List<Double> findLevelAverages(TreeNode root) {
        return Collections.emptyList();
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
