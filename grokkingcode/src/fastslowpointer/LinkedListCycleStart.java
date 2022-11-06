package fastslowpointer;

public class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        int len = cycleLength(head);
        ListNode first = head;
        ListNode second = head;
        while (len > 0) {
            first = first.next;
            len--;
        }
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    static int cycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 1;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode cur = slow.next;
                while (cur != slow) {
                    count++;
                    cur = cur.next;
                }
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value); // 3

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value); // 4

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value); // 1
    }
}