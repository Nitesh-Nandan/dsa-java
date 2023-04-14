package grind75;

import grind75.node.ListNode;

public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = null;
        ListNode tail = null;

        while (list1 != null && list2 != null) {
            if (head == null) {
                if (list1.val <= list2.val) {
                    head = list1;
                    tail = head;
                    list1 = list1.next;
                } else {
                    head = list2;
                    tail = head;
                    list2 = list2.next;
                }
            } else {
                if (list1.val <= list2.val) {
                    tail.next = list1;
                    list1 = list1.next;
                } else {
                    tail.next = list2;
                    list2 = list2.next;
                }
                tail = tail.next;
            }
        }

        while (list1 != null) {
            tail.next = list1;
            list1 = list1.next;
            tail = tail.next;
        }

        while (list2 != null) {
            tail.next = list2;
            list2 = list2.next;
            tail = tail.next;
        }

        return head;

    }
}
