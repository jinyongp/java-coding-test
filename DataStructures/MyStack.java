import java.util.ArrayList;
import java.util.Stack;

public class MyStack<T> {
  private ArrayList<T> _stack = new ArrayList<T>();

  public void push(T item) {
    _stack.add(item);
  }

  public T pop() {
    return _stack.isEmpty() ? null : _stack.remove(_stack.size() - 1);
  }

  public boolean isEmpty() {
    return _stack.isEmpty();
  }

  public String toString() {
    return _stack.toString();
  }

  public static void main(String[] args) {
    // Stack 클래스를 이용한다.
    Stack<Integer> stack = new Stack<Integer>();

    stack.push(1);
    stack.push(2);
    stack.push(3);

    System.out.println(stack);

    System.out.println(stack.pop()); // 3
    System.out.println(stack.pop()); // 2
    System.out.println(stack.pop()); // 1
    // System.out.println(stack.pop()); // error!

    MyStack<Integer> my_stack = new MyStack<Integer>();

    my_stack.push(1);
    my_stack.push(2);
    my_stack.push(3);

    System.out.println(my_stack);

    System.out.println(my_stack.pop()); // 3
    System.out.println(my_stack.pop()); // 2
    System.out.println(my_stack.pop()); // 1
    System.out.println(my_stack.pop()); // null

  }
}
