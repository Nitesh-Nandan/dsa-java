package mergeInterval;

import java.util.Arrays;

public class ConflictingAppointments {

    static boolean isConflicting(Intervals[] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        Intervals prev = intervals[0];
        int i = 1;
        while (i < intervals.length) {
            Intervals cur = intervals[i];
            if(prev.end > cur.start) {
                return false;
            }
            prev = cur;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Intervals[] intervals = { new Intervals(1, 4), new Intervals(2, 5), new Intervals(7, 9) };
        boolean result = isConflicting(intervals);
        System.out.println("Can attend all appointments: " + result); // false

        Intervals[] intervals1 = { new Intervals(6, 7), new Intervals(2, 4), new Intervals(8, 12) };
        result = isConflicting(intervals1);
        System.out.println("Can attend all appointments: " + result); // true

        Intervals[] intervals2 = { new Intervals(4, 5), new Intervals(2, 3), new Intervals(3, 6) };
        result = isConflicting(intervals2);
        System.out.println("Can attend all appointments: " + result); // false
    }
}
