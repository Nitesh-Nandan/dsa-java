package twoheaps;

import util.TestCaseUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class ScheduleTask {
    public static int tasks(ArrayList<ArrayList<Integer>> tasksList) {
        tasksList.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.get(1), b.get(1)));
        int ans = 0;

        for (ArrayList<Integer> currTask : tasksList) {
            while (!queue.isEmpty() && queue.peek().get(1) <= currTask.get(0)) {
                queue.poll();
            }
            queue.offer(currTask);
            ans = Math.max(ans, queue.size());
        }
        return ans;
    }
}

public class MinimumMachineToScheduleTask {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    static void test1() {
        ArrayList<ArrayList<Integer>> tasks = new ArrayList<>();
        tasks.add(new ArrayList<>(Arrays.asList(1, 1)));
        tasks.add(new ArrayList<>(Arrays.asList(5, 5)));
        tasks.add(new ArrayList<>(Arrays.asList(8, 8)));
        tasks.add(new ArrayList<>(Arrays.asList(4, 4)));
        tasks.add(new ArrayList<>(Arrays.asList(6, 6)));
        tasks.add(new ArrayList<>(Arrays.asList(10, 10)));
        tasks.add(new ArrayList<>(Arrays.asList(7, 7)));

        TestCaseUtil.run(1, ScheduleTask.tasks(tasks), 1);
    }

    static void test2() {
        ArrayList<ArrayList<Integer>> tasks = new ArrayList<>();
        tasks.add(new ArrayList<>(Arrays.asList(1, 7)));
        tasks.add(new ArrayList<>(Arrays.asList(1, 7)));
        tasks.add(new ArrayList<>(Arrays.asList(1, 7)));
        tasks.add(new ArrayList<>(Arrays.asList(1, 7)));
        tasks.add(new ArrayList<>(Arrays.asList(1, 7)));
        tasks.add(new ArrayList<>(Arrays.asList(1, 7)));

        TestCaseUtil.run(6, ScheduleTask.tasks(tasks), 2);
    }

    static void test3() {
        ArrayList<ArrayList<Integer>> tasks = new ArrayList<>();
        tasks.add(new ArrayList<>(Arrays.asList(1, 7)));
        tasks.add(new ArrayList<>(Arrays.asList(8, 13)));
        tasks.add(new ArrayList<>(Arrays.asList(5, 6)));
        tasks.add(new ArrayList<>(Arrays.asList(10, 14)));
        tasks.add(new ArrayList<>(Arrays.asList(6, 7)));

        TestCaseUtil.run(2, ScheduleTask.tasks(tasks), 3);
    }

    static void test4() {
        ArrayList<ArrayList<Integer>> tasks = new ArrayList<>();
        tasks.add(new ArrayList<>(Arrays.asList(1, 3)));
        tasks.add(new ArrayList<>(Arrays.asList(3, 5)));
        tasks.add(new ArrayList<>(Arrays.asList(5, 9)));
        tasks.add(new ArrayList<>(Arrays.asList(9, 12)));
        tasks.add(new ArrayList<>(Arrays.asList(12, 13)));
        tasks.add(new ArrayList<>(Arrays.asList(13, 16)));
        tasks.add(new ArrayList<>(Arrays.asList(16, 17)));

        TestCaseUtil.run(1, ScheduleTask.tasks(tasks), 4);
    }

    static void test5() {
        ArrayList<ArrayList<Integer>> tasks = new ArrayList<>();
        tasks.add(new ArrayList<>(Arrays.asList(12, 13)));
        tasks.add(new ArrayList<>(Arrays.asList(13, 15)));
        tasks.add(new ArrayList<>(Arrays.asList(17, 20)));
        tasks.add(new ArrayList<>(Arrays.asList(13, 14)));
        tasks.add(new ArrayList<>(Arrays.asList(19, 21)));
        tasks.add(new ArrayList<>(Arrays.asList(18, 20)));

        TestCaseUtil.run(3, ScheduleTask.tasks(tasks), 5);
    }
}
