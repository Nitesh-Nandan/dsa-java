package mergeInterval;

public class ConflictingAppointments {

    static boolean canAttendAllMeetings(Intervals[] intervals) {
        return true;
    }

    public static void main(String[] args) {
        Intervals[] intervals = { new Intervals(1, 4), new Intervals(2, 5), new Intervals(7, 9) };
        boolean result = canAttendAllMeetings(intervals);
        System.out.println("Can attend all appointments: " + result); // false

        Intervals[] intervals1 = { new Intervals(6, 7), new Intervals(2, 4), new Intervals(8, 12) };
        result = canAttendAllMeetings(intervals1);
        System.out.println("Can attend all appointments: " + result); // true

        Intervals[] intervals2 = { new Intervals(4, 5), new Intervals(2, 3), new Intervals(3, 6) };
        result = canAttendAllMeetings(intervals2);
        System.out.println("Can attend all appointments: " + result); // false
    }
}
