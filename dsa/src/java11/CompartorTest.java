package java11;

import java.util.Arrays;
import java.util.List;

class Node {
    boolean valid;
    int rank;

    public Node(boolean valid, int rank) {
        this.valid = valid;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Node{" +
                "valid=" + valid +
                ", rank=" + rank +
                '}';
    }
}

public class CompartorTest {

    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        List<Node> nodes = Arrays.asList(
                new Node(true, 1),
                new Node(true, 2),
                new Node(false, 1),
                new Node(false, 2),
                new Node(true, 5)
        );

        nodes.sort((n1, n2) -> {
            if(n1.valid != n2.valid) {
                return n1.valid ? -1 : 1;
            } else {
                return n1.rank - n2.rank;
            }
        } );

        System.out.println(nodes);
    }

    private static void test2() {
        List<Node> nodes = Arrays.asList(
                new Node(true, 6),
                new Node(true, 8),
                new Node(false, 5),
                new Node(false, 1),
                new Node(true, 3)
        );

        nodes.sort((n1, n2) -> {
            if(n1.valid != n2.valid) {
                return n1.valid ? -1 : 1;
            } else {
                return n1.rank - n2.rank;
            }
        } );

        System.out.println(nodes);
    }
}
