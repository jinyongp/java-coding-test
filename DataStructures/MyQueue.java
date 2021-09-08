import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {
  private ArrayList<T> _queue = new ArrayList<T>();

  public void enqueue(T item) {
    _queue.add(item);
  }

  public T dequeue() {
    return _queue.isEmpty() ? null : _queue.remove(0);
  }

  public boolean isEmpty() {
    return _queue.isEmpty();
  }

  public String toString() {
    return _queue.toString();
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
    MyQueue<Integer> my_queue = new MyQueue<Integer>();

    my_queue.enqueue(1);
    my_queue.enqueue(2);
    my_queue.enqueue(3);

    System.out.println(my_queue); // [1, 2, 3]

    System.out.println(my_queue.dequeue()); // 1
    System.out.println(my_queue.dequeue()); // 2
    System.out.println(my_queue.dequeue()); // 3
    System.out.println(my_queue.dequeue()); // null
  }
}
