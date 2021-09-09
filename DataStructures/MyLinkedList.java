public class MyLinkedList {
  public static void main(String[] args) {
    SingleLinkedList<Integer> singleList = new SingleLinkedList<Integer>();

    System.out.println("SingleLinkedList Test");

    singleList.add(1);
    singleList.add(2);
    singleList.add(3);

    System.out.println(singleList);

    singleList.addBehind(5, 1);
    singleList.addBehind(10, 6);

    System.out.println(singleList);

    System.out.println(singleList.delete(1));
    System.out.println(singleList.delete(2));
    System.out.println(singleList.delete(10));
    System.out.println(singleList.delete(15));

    System.out.println(singleList);

    DoubleLinkedList<Integer> doubleList = new DoubleLinkedList<Integer>();

    System.out.println("DoubleLinkedList Test");

    doubleList.add(1);
    doubleList.add(2);
    doubleList.add(3);
    doubleList.add(4);
    doubleList.add(5);

    System.out.println(doubleList);

    System.out.println(doubleList.delete(1));
    System.out.println(doubleList.delete(3));
    System.out.println(doubleList.delete(5));
    System.out.println(doubleList.delete(7));

    System.out.println(doubleList);
  }
}

class SingleLinkedList<T> {
  private Node<T> head = null;

  public class Node<K> {
    K data;
    Node<K> next = null;

    public Node(K data) {
      this.data = data;
    }
  }

  public void add(T data) {
    if (head == null) {
      head = new Node<T>(data);
    } else {
      Node<T> node = this.head;
      while (node.next != null) {
        node = node.next;
      }
      node.next = new Node<T>(data);
    }
  }

  public Node<T> search(T data) {
    Node<T> node = this.head;
    while (node != null) {
      if (node.data == data) {
        return node;
      }
      node = node.next;
    }
    return null;
  }

  public void addBehind(T data, T target) {
    Node<T> searchedNode = this.search(target);

    if (searchedNode == null) {
      this.add(data);
    } else {
      Node<T> nextNode = searchedNode.next;
      searchedNode.next = new Node<T>(data);
      searchedNode.next.next = nextNode;
    }
  }

  public boolean delete(T data) {
    Node<T> node = this.head;
    if (node.data == data) {
      this.head = this.head.next;
      return true;
    }

    while (node.next != null) {
      if (node.next.data == data) {
        node.next = node.next.next;
        return true;
      }
      node = node.next;
    }

    return false;
  }

  public String toString() {
    if (head == null) {
      return "[]";
    }

    String str = "[";
    Node<T> node = this.head;
    while (node != null) {
      str += node.data + ", ";
      node = node.next;
    }
    return str.substring(0, str.length() - 2) + "]";
  }
}

class DoubleLinkedList<T> {
  private Node<T> head = null;
  private Node<T> tail = null;

  public class Node<K> {
    K data;
    Node<K> prev = null;
    Node<K> next = null;

    public Node(K data) {
      this.data = data;
    }
  }

  public void add(T data) {
    if (this.head == null) {
      this.head = this.tail = new Node<T>(data);
    } else {
      Node<T> node = this.head;
      while (node.next != null) {
        node = node.next;
      }
      node.next = new Node<T>(data);
      node.next.prev = node;
      this.tail = node.next;
    }
  }

  public boolean delete(T data) {
    Node<T> node = this.head;

    if (node.data == data) {
      this.head = node.next;
      this.head.prev = null;
      return true;
    }

    while (node.next != null) {
      if (node.next.data == data) {
        node.next = node.next.next;
        if (node.next != null) {
          node.next.prev = node;
        }
        return true;
      }
      node = node.next;
    }

    return false;
  }

  public T searchFromHead(T data) {
    Node<T> node = this.head;
    while (node != null) {
      if (node.data == data) {
        return node.data;
      }
      node = node.next;
    }
    return null;
  }

  public T searchFromTail(T data) {
    Node<T> node = this.tail;
    while (node != null) {
      if (node.data == data) {
        return node.data;
      }
      node = node.prev;
    }
    return null;
  }

  public String toString() {
    if (head == null) {
      return "[]";
    }

    String str = "[";
    Node<T> node = this.head;
    while (node != null) {
      str += node.data + ", ";
      node = node.next;
    }
    return str.substring(0, str.length() - 2) + "]";
  }
}
