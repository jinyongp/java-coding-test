import java.util.Collections;
import java.util.PriorityQueue;

public class MyHeap {
  public static void main(String[] args) {
    // PriorityQueue 클래스를 Heap처럼 사용할 수 있다.
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    minHeap.add(3);
    minHeap.add(10);
    minHeap.add(1);
    minHeap.add(2);

    System.out.println(minHeap);

    System.out.println(minHeap.peek());
    System.out.println(minHeap.remove());
    System.out.println(minHeap.remove());
    System.out.println(minHeap.remove());
    System.out.println(minHeap.remove());

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

    maxHeap.add(3);
    maxHeap.add(10);
    maxHeap.add(1);
    maxHeap.add(2);

    System.out.println(maxHeap);

    System.out.println(maxHeap.peek());
    System.out.println(maxHeap.remove());
    System.out.println(maxHeap.remove());
    System.out.println(maxHeap.remove());
    System.out.println(maxHeap.remove());
  }
}
