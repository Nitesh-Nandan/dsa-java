package mergeInterval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


public class MinimumMeetingRooms {
    static int findMinimumMeetingRooms(List<Meeting> input) {
        if(input.size() < 2) return 1;
        int res = 1;
        input.sort((a,b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Meeting> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));

        for (Meeting meeting : input) {
            while (!queue.isEmpty() && queue.peek().end <= meeting.start) {
              queue.poll();
            }
            queue.offer(meeting);

            res = Math.max(res, queue.size());
        }
        return res;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result); // 2

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result); // 1

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result); // 2

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result); // 2

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 7));
                add(new Meeting(8, 13));
                add(new Meeting(5, 6));
                add(new Meeting(10, 14));
                add(new Meeting(6, 7));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result); // 2

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 2));
                add(new Meeting(2, 3));
                add(new Meeting(3, 4));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result); // 2
    }
}
