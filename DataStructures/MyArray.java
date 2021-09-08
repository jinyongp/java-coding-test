import java.util.ArrayList;
import java.util.Arrays;

public class MyArray {

  public static void main(String[] args) {
    // new 키워드로 배열을 미리 선언
    Integer[] array1 = new Integer[10];

    // 배열 선언 시 데이터 할당
    Integer[] array2 = { 1, 2, 3, 4, 5 };

    // 배열을 보다 손쉽게 다루기 위해 Arrays 클래스 이용
    System.out.println(Arrays.toString(array1));
    System.out.println(Arrays.toString(array2));

    // 가변 길이의 배열을 다루기 위해 ArrayList 클래스 이용
    ArrayList<Integer> list = new ArrayList<Integer>();

    list.add(1);
    list.add(2);
    list.add(3);

    System.out.println(list.size()); // 3
    System.out.println(list.get(1)); // 2
    System.out.println(list.remove(1)); // 2
    System.out.println(list.toString()); // [1, 2]
  }
}
