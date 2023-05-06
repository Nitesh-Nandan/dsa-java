package java11;

//Given a binary tree, check whether it is a mirror of itself or not (i.e. Symmetric or not)
//
//        Examples:
//
//        Input :
//
//         1
//        /   \
//        2     2
//        / \   / \
//        3   4 4   3
//
//        Output : Symmetric
//
//        Input :
//
//        1
//        / \
//        2   2
//        \   \
//        3    3
//
//        Output : Not Symmetric

// left and right both are null -> true
 //  left || right = null -> false
// left.val != right.val = false;
//
//


public class Test3 {
    static  class  Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int val) {
            this.data = val;
        }
    }

    public static boolean isMirror(Node node) {
        if(node == null) return true;
        return helper(node.left, node.right);

    }

    private static boolean helper(Node lNode, Node rNode) {
        if(lNode == null && rNode == null) {
            return true;
        }
        if(lNode == null || rNode == null) {
            return false;
        }
        if(lNode.data != rNode.data) return false;
        return helper(lNode.left, rNode.right) && helper(lNode.right, rNode.left);
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
//         1
////        /   \
////        2     2
////        / \   / \
////        3   4 4   3

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(2);

        root.left.left = new Node(3);
        root.left.right = new Node(4);


        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println(isMirror(root));

    }

    private static void test2() {
        //
//        1
//        / \
//        2   2
//        \   \
//        3    3

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(2);

        root.left.right = new Node(3);
        root.right.left = new Node(3);

        System.out.println(isMirror(root));


    }
}
