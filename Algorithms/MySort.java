import java.util.ArrayList;
import java.util.Collections;

public class MySort {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();

    for (int i = 0; i < 10; ++i) {
      numbers.add((int) (Math.random() * 100));
    }
    System.out.println("Numbers:\t" + numbers);

    System.out.println("Bubble:\t\t" + bubble(numbers));
    System.out.println("Selection:\t" + selection(numbers));
    System.out.println("Insertion:\t" + insertion(numbers));
    System.out.println("Merge:\t\t" + merge(numbers));
    System.out.println("Quick:\t\t" + quick(numbers));
  }

  /**
   * 시간 복잡도: O(N^2)
   *
   * 이미 정렬되어 있는 경우, O(N)
   *
   * @param items
   * @return sorted list by ascending order
   */
  public static ArrayList<Integer> bubble(ArrayList<Integer> items) {
    ArrayList<Integer> copy = new ArrayList<Integer>(items);

    for (int i = 0; i < copy.size() - 1; ++i) {
      boolean swap = false;
      for (int j = 0; j < copy.size() - i - 1; ++j) {
        if (copy.get(j) > copy.get(j + 1)) {
          Collections.swap(copy, j, j + 1);
          swap = true;
        }
      }
      if (!swap) {
        break;
      }
    }

    return copy;
  }

  /**
   * 시간 복잡도: O(N^2)
   *
   * @param items
   * @return sorted list by ascending order
   */
  public static ArrayList<Integer> selection(ArrayList<Integer> items) {
    ArrayList<Integer> copy = new ArrayList<Integer>(items);

    int selectedIndex = 0;
    for (int i = 0; i < copy.size() - 1; selectedIndex = ++i) {
      for (int j = i + 1; j < copy.size(); ++j) {
        if (copy.get(selectedIndex) > copy.get(j)) {
          selectedIndex = j;
        }
      }
      Collections.swap(copy, selectedIndex, i);
    }

    return copy;
  }

  /**
   * 시간 복잡도: O(N^2)
   *
   * 이미 정렬되어 있는 경우, O(N)
   *
   * @param items
   * @return sorted list by ascending order
   */
  public static ArrayList<Integer> insertion(ArrayList<Integer> items) {
    ArrayList<Integer> copy = new ArrayList<Integer>(items);

    for (int i = 0; i < copy.size() - 1; ++i) {
      for (int j = i + 1; j > 0; --j) {
        if (copy.get(j) < copy.get(j - 1)) {
          Collections.swap(copy, j, j - 1);
        } else {
          break;
        }
      }
    }

    return copy;
  }

  /**
   * 시간 복잡도: O(NlogN)
   *
   * @param items
   * @return sorted list by ascending order
   */
  public static ArrayList<Integer> merge(ArrayList<Integer> items) {
    if (items.size() <= 1) {
      return items;
    }

    int mid = items.size() / 2;
    ArrayList<Integer> left = merge(new ArrayList<Integer>(items.subList(0, mid)));
    ArrayList<Integer> right = merge(new ArrayList<Integer>(items.subList(mid, items.size())));
    ArrayList<Integer> mergedList = new ArrayList<Integer>();
    int leftIndex = 0;
    int rightIndex = 0;

    while (left.size() > leftIndex && right.size() > rightIndex) {
      if (left.get(leftIndex) > right.get(rightIndex)) {
        mergedList.add(right.get(rightIndex++));
      } else {
        mergedList.add(left.get(leftIndex++));
      }
    }

    while (left.size() > leftIndex) {
      mergedList.add(left.get(leftIndex++));
    }

    while (right.size() > rightIndex) {
      mergedList.add(right.get(rightIndex++));
    }

    return mergedList;
  }

  /**
   *
   * 시간 복잡도: O(NlogN)
   *
   * pivot이 항상 가장 작거나 가장 클 경우, O(N^2)
   *
   * @param items
   * @return sorted list by ascending order
   */
  public static ArrayList<Integer> quick(ArrayList<Integer> items) {
    if (items.size() <= 1) {
      return items;
    }
    Integer pivot = items.get(0);

    ArrayList<Integer> left = new ArrayList<Integer>();
    ArrayList<Integer> right = new ArrayList<Integer>();

    for (int i = 1; i < items.size(); ++i) {
      if (items.get(i) > pivot) {
        right.add(items.get(i));
      } else {
        left.add(items.get(i));
      }
    }

    ArrayList<Integer> mergedList = new ArrayList<Integer>() {
      { // double brace initialization
        addAll(quick(left));
        add(pivot);
        addAll(quick(right));
      }
    };

    return mergedList;
  }
}
