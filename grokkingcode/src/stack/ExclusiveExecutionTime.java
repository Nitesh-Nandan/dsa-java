package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveExecutionTime {
    public static List<Integer> exclusiveTime(int n, List<String> events) {
        Stack<Job> scheduled = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(0);
        }
        events.stream().forEach(event -> {
            Job curr = new Job(event);
            if (curr.isStarted) {
                scheduled.push(curr);
            } else {
                Job prev = scheduled.pop();
                int exTime = curr.time - prev.time - prev.holdTime + 1;
                ans.set(curr.jobId, ans.get(curr.jobId) + exTime);
                if (!scheduled.isEmpty()) {
                    ans.set(scheduled.peek().jobId, ans.get(scheduled.peek().jobId) - exTime);
                }
            }
        });

        return ans;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() {
        List<String> logs = Arrays.asList("0:start:0", "1:start:6", "1:end:6", "0:end:7");
        System.out.println(exclusiveTime(2, logs)); // [7, 1]
    }

    static void test2() {
        List<String> logs = Arrays.asList("0:start:0", "1:start:3", "1:end:6", "0:end:10");
        System.out.println(exclusiveTime(2, logs)); // [7, 4]
    }

    static void test3() {
        List<String> logs = Arrays.asList("0:start:0", "0:end:0", "1:start:1", "1:end:1", "2:start:2", "2:end:2", "2:start:3", "2:end:3");
        System.out.println(exclusiveTime(3, logs)); // [1, 1, 2]
    }

    static void test4() {
        List<String> logs = Arrays.asList("0:start:0", "1:start:5", "2:start:8", "3:start:12", "4:start:15", "5:start:19", "5:end:22", "4:end:24", "3:end:27", "2:end:32", "1:end:35", "0:end:36");
        System.out.println(exclusiveTime(6, logs)); // [6, 6, 9, 6, 6, 4]
    }

    static class Job {
        int jobId;
        boolean isStarted;
        int time;
        int holdTime;

        public Job(String event) {
            String[] ev = event.split(":");
            this.jobId = Integer.parseInt(ev[0]);
            this.isStarted = "start".equalsIgnoreCase(ev[1]);
            this.time = Integer.parseInt(ev[2]);
        }
    }

}
