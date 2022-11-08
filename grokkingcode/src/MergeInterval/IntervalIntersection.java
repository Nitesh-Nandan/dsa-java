package MergeInterval;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    private static Intervals[] getIntervalIntersection(Intervals[] input1, Intervals[] input2) {
        List<Intervals> intersections = new ArrayList<>();
        int i = 0, j = 0;

        while (i < input1.length && j < input2.length) {
            Intervals t1 = input1[i];
            Intervals t2 = input2[j];
            if (t1.end < t2.start) {
                i++;
            } else if (t1.start > t2.end) {
                j++;
            } else {
                intersections.add(new Intervals(Math.max(t1.start, t2.start), Math.min(t1.end, t2.end)));
                if (t1.end < t2.end) i++;
                else j++;
            }
        }
        return intersections.toArray(new Intervals[0]);
    }

    public static void main(String[] args) {
        Intervals[] input1 = new Intervals[]{new Intervals(1, 3), new Intervals(5, 6), new Intervals(7, 9)};
        Intervals[] input2 = new Intervals[]{new Intervals(2, 3), new Intervals(5, 7)};
        Intervals[] result = getIntervalIntersection(input1, input2);
        System.out.print("Intervalss Intersection: ");
        for (Intervals Intervals : result)
            System.out.print("[" + Intervals.start + "," + Intervals.end + "] ");
        System.out.println();

        input1 = new Intervals[]{new Intervals(1, 3), new Intervals(5, 7), new Intervals(9, 12)};
        input2 = new Intervals[]{new Intervals(5, 10)};
        result = getIntervalIntersection(input1, input2);
        System.out.print("Intervalss Intersection: ");
        for (Intervals Intervals : result)
            System.out.print("[" + Intervals.start + "," + Intervals.end + "] ");
    }

}
