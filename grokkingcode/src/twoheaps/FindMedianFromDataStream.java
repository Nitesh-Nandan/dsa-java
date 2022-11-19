package twoheaps;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianOfAStream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianOfAStream() {
        // Write your code here
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        }
        return 1.0 * maxHeap.peek();
    }
}

public class FindMedianFromDataStream {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    static void test1() {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(1);
        medianOfAStream.insertNum(2);
        System.out.println(medianOfAStream.findMedian());
        medianOfAStream.insertNum(3);
        System.out.println(medianOfAStream.findMedian());
    }

    static void test2() {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(1);
        System.out.println(medianOfAStream.findMedian());
        medianOfAStream.insertNum(1);
        System.out.println(medianOfAStream.findMedian());
    }
}
