import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {
  private ArrayList<T> queue = new ArrayList<T>();

  public void enqueue(T item) {
    queue.add(item);
  }

  public T dequeue() {
    return queue.isEmpty() ? null : queue.remove(0);
  }

  public boolean isEmpty() {
    return queue.isEmpty();
  }

  public String toString() {
    return queue.toString();
  }

  public static void main(String[] args) {
    // Queue는 LinkedList 클래스를 이용해 생성할 수 있다.
    Queue<Integer> queue = new LinkedList<Integer>();

    // add와 offer 동일
    queue.add(1);
    queue.offer(2);

    System.out.println(queue);

    // poll과 remove 동일
    System.out.println(queue.poll()); // 1
    System.out.println(queue.remove()); // 2

    System.out.println(queue);

    // 직접 정의한 Queue 클래스
    MyQueue<Integer> myQueue = new MyQueue<Integer>();

    myQueue.enqueue(1);
    myQueue.enqueue(2);
    myQueue.enqueue(3);

    System.out.println(myQueue); // [1, 2, 3]

    System.out.println(myQueue.dequeue()); // 1
    System.out.println(myQueue.dequeue()); // 2
    System.out.println(myQueue.dequeue()); // 3
    System.out.println(myQueue.dequeue()); // null
  }
}
