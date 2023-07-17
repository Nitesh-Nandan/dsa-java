package kwaymerge;

import util.Pair;
import util.TestCaseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestKNumber {
    private static int findKthSmallestNumber(List<Integer[]> lists, int k) {
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(
                (a, b) -> Integer.compare(lists.get(a.getKey())[a.getValue()], lists.get(b.getKey())[b.getValue()]));

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).length != 0) {
                queue.offer(new Pair<>(i, 0));
            }
        }

        int visited = 0;
        int ans = 0;

        while (!queue.isEmpty() && visited < k) {
            Pair<Integer, Integer> offset = queue.poll();
            ans = lists.get(offset.getKey())[offset.getValue()];

            if (offset.getValue() < lists.get(offset.getKey()).length - 1) {
                queue.offer(new Pair<>(offset.getKey(), offset.getValue() + 1));
            }
            visited++;
        }

        return ans;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test1() {
        Integer[] l1 = new Integer[]{2, 6, 8};
        Integer[] l2 = new Integer[]{3, 6, 10};
        Integer[] l3 = new Integer[]{5, 8, 11};
        List<Integer[]> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        TestCaseUtil.test(6, findKthSmallestNumber(lists, 5), 1);
    }

    private static void test2() {
        Integer[] l11 = new Integer[]{1, 2, 3};
        Integer[] l21 = new Integer[]{4, 5};
        Integer[] l31 = new Integer[]{6, 7, 8, 15};
        Integer[] l41 = new Integer[]{10, 11, 12, 13};
        Integer[] l51 = new Integer[]{5, 10};
        List<Integer[]> lists1 = new ArrayList<>();
        lists1.add(l11);
        lists1.add(l21);
        lists1.add(l31);
        lists1.add(l41);
        lists1.add(l51);

        TestCaseUtil.test(15, findKthSmallestNumber(lists1, 50), 2);
    }

    private static void test3() {
        Integer[] l111 = new Integer[]{};
        Integer[] l211 = new Integer[]{};
        Integer[] l311 = new Integer[]{};
        List<Integer[]> lists2 = new ArrayList<>();
        lists2.add(l111);
        lists2.add(l211);
        lists2.add(l311);

        TestCaseUtil.test(0, findKthSmallestNumber(lists2, 4), 3);
    }

    private static void test4() {
        Integer[] l1111 = new Integer[]{1, 1, 3, 8};
        Integer[] l2111 = new Integer[]{5, 5, 7, 9};
        Integer[] l3111 = new Integer[]{3, 5, 8, 12};
        List<Integer[]> lists3 = new ArrayList<>();
        lists3.add(l1111);
        lists3.add(l2111);
        lists3.add(l3111);

        TestCaseUtil.test(3, findKthSmallestNumber(lists3, 4), 4);
    }

    private static void test5() {
        Integer[] l11111 = new Integer[]{5, 8, 9, 17};
        Integer[] l21111 = new Integer[]{};
        Integer[] l31111 = new Integer[]{21, 22, 23, 24};
        List<Integer[]> lists4 = new ArrayList<>();
        lists4.add(l11111);
        lists4.add(l21111);
        lists4.add(l31111);

        TestCaseUtil.test(24, findKthSmallestNumber(lists4, 8), 5);
    }
}
