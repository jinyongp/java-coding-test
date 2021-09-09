import java.util.Collections;
import java.util.TreeSet;

public class MyTree {
  public static void main(String[] args) {
    // TreeMap 혹은 TreeSet 클래스를 이용해 이진 트리를 생성할 수 있다.
    // Hash에 비해 값을 삽입하거나 삭제하기에 느리지만, 데이터를 정렬된 상태로 유지하기에 용이하다.
    TreeSet<Integer> bTreeASC = new TreeSet<Integer>();

    bTreeASC.add(1);
    bTreeASC.add(3);
    bTreeASC.add(5);
    bTreeASC.add(10);
    bTreeASC.add(2);
    bTreeASC.add(4);

    System.out.println(bTreeASC); // [1, 2, 3, 4, 5, 10]

    System.out.println(bTreeASC.higher(3)); // 4
    System.out.println(bTreeASC.remove(3)); // true

    System.out.println(bTreeASC); // [1, 2, 4, 5, 10]

    TreeSet<Integer> bTreeDESC = new TreeSet<Integer>(Collections.reverseOrder());

    bTreeDESC.add(1);
    bTreeDESC.add(3);
    bTreeDESC.add(5);
    bTreeDESC.add(10);
    bTreeDESC.add(2);
    bTreeDESC.add(4);

    System.out.println(bTreeDESC); // [10, 5, 4, 3, 2, 1]
  }
}
