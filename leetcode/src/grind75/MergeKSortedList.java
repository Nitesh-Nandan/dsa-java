package grind75;

import grind75.node.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (n1, n2) -> Integer.compare(n1.val, n2.val));

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode head = null;
        ListNode tail = null;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (head == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return head;
    }
}
