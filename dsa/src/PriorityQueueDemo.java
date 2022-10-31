import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Comparator<Integer> comp = (a,b) -> b-a;
        Queue<Integer> queue = new PriorityQueue<>(comp);
        queue.add(100);
        queue.add(50);
        queue.add(150);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }   
}
