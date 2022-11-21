package ktopelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosetPointToOrigin {

    private static List<Point> kClosetPoints(Point[] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.distFromOrigin(), a.distFromOrigin()));

        for (int i = 0; i < points.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.offer(points[i]);
            } else if (!maxHeap.isEmpty() && maxHeap.peek().distFromOrigin() > points[i].distFromOrigin()) {
                maxHeap.poll();
                maxHeap.offer(points[i]);
            }
        }

        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    static void test1() {
        Point[] points = new Point[]{
                new Point(-1, -3), new Point(-4, -5), new Point(-2, -2), new Point(-2, -3)
        };

        // [( x= -2, y=-3 ), ( x= -2, y=-2 ), ( x= -1, y=-3 )]
        System.out.println(kClosetPoints(points, 3));
    }

    static void test2() {
        Point[] points = new Point[]{
                new Point(1, 3), new Point(2, 4), new Point(2, -1),
                new Point(-2, 2), new Point(5, 3), new Point(3, -2)
        };

        // [( x= 1, y=3 ), ( x= 2, y=-1 ), ( x= -2, y=2 )]
        System.out.println(kClosetPoints(points, 3));
    }

    static void test3() {
        Point[] points = new Point[]{
                new Point(1, 3), new Point(-2, 4), new Point(2, -1),
                new Point(-2, 2), new Point(5, -3), new Point(3, -2)
        };

        // [( x= 1, y=3 ), ( x= 2, y=-1 ), ( x= -2, y=2 )]
        System.out.println(kClosetPoints(points, 3));
    }

    static void test4() {
        Point[] points = new Point[]{
                new Point(1, 3), new Point(2, -4), new Point(2, -1), new Point(-2, -2)
        };

        // [( x= 1, y=3 ), ( x= 2, y=-1 ), ( x= -2, y=-2 )]
        System.out.println(kClosetPoints(points, 3));
    }

    static void test5() {
        Point[] points = new Point[]{
                new Point(1, -3), new Point(4, -2), new Point(2, -1), new Point(-2, 2),
                new Point(-5, 3), new Point(3, -2)
        };

        // [( x= 3, y=-2 ), ( x= 1, y=-3 ), ( x= 2, y=-1 ), ( x= -2, y=2 )]
        System.out.println(kClosetPoints(points, 4));
    }

    static void test6() {
        Point[] points = new Point[]{
                new Point(-1, -3), new Point(-2, -2), new Point(-2, -3), new Point(-4, -5)
        };

        // [( x= -2, y=-3 ), ( x= -2, y=-2 ), ( x= -1, y=-3 )]
        System.out.println(kClosetPoints(points, 3));
    }
}
