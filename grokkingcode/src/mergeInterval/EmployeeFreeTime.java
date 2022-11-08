package mergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class EmployeeInterval {
    Interval interval;
    int employeeIndex;
    int intervalIndex;

    public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
    }
}

class EmployeeFreeTime {

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.interval.start, b.interval.start));

        for (int i = 0; i < schedule.size(); i++) {
            minHeap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));
        }

        Interval previousInterval = minHeap.peek().interval;

        while (!minHeap.isEmpty()) {
            EmployeeInterval curEmpInterval = minHeap.poll();

            if (previousInterval.end < curEmpInterval.interval.start) {
                result.add(new Interval(previousInterval.end, curEmpInterval.interval.start));
                previousInterval = curEmpInterval.interval;
            } else {
                if (curEmpInterval.interval.end > previousInterval.end) {
                    previousInterval = curEmpInterval.interval;
                }
            }

            List<Interval> curEmployeeIntervalList = schedule.get(curEmpInterval.employeeIndex);

            if (curEmpInterval.intervalIndex + 1 < curEmployeeIntervalList.size()) {
                minHeap.offer(
                        new EmployeeInterval(
                                curEmployeeIntervalList.get(curEmpInterval.intervalIndex + 1),
                                curEmpInterval.employeeIndex,
                                curEmpInterval.intervalIndex + 1
                        )
                );
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] "); // [3,5]
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] "); // [4,6] [8,9]
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] "); // [5,7]
    }
}
