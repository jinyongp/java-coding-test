import java.util.ArrayList;
import java.util.Stack;

public class MyStack<T> {
  private ArrayList<T> stack = new ArrayList<T>();

  public void push(T item) {
    stack.add(item);
  }

  public T pop() {
    return stack.isEmpty() ? null : stack.remove(stack.size() - 1);
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }

  public String toString() {
    return stack.toString();
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

    MyStack<Integer> myStack = new MyStack<Integer>();

    myStack.push(1);
    myStack.push(2);
    myStack.push(3);

    System.out.println(myStack);

    System.out.println(myStack.pop()); // 3
    System.out.println(myStack.pop()); // 2
    System.out.println(myStack.pop()); // 1
    System.out.println(myStack.pop()); // null

  }
}
