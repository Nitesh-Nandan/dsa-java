package javads;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class JavaQueueDemo {
    public static void main(String[] args) {
        arrayDequeDemo();
        minHeapDemo();
        maxHeapDemo();
        queueDemo();
    }

    static void arrayDequeDemo() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(10);
        deque.offer(20);
        deque.add(30);
        deque.push(40);
        deque.push(50);

        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }
    }

    static void minHeapDemo() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a, b));
        minHeap.add(100);
        minHeap.offer(30);
        minHeap.add(50);
        minHeap.add(150);
        minHeap.add(5);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }

    static void maxHeapDemo() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> -1 * Integer.compare(a, b));
        minHeap.add(100);
        minHeap.offer(30);
        minHeap.add(50);
        minHeap.add(150);
        minHeap.add(5);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }

    static void queueDemo() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(30);
        queue.offer(50);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
