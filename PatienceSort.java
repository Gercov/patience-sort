import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PatienceSort {

  public static <T extends Comparable<? super T>> void sort(List<T> list) {
    List<Stack<T>> piles = new ArrayList<>();
    for (T x : list) {
      int i = binarySearch(piles, x);
      if (i == piles.size()) {
        piles.add(new Stack<>());
      }
      piles.get(i).push(x);
    }
    int iterations = 0;
    for (int i = 0; i < list.size();) {
      for (Stack<T> pile : piles) {
        if (pile.empty()) {
          continue;
        }
        T x = pile.pop();
        list.set(i++, x);
        iterations++;
      }
    }
    PatienceSortIterations.setCount(iterations);
  }

  private static <T extends Comparable<? super T>> int binarySearch(List<Stack<T>> piles, T x) {
    int left = 0;
    int right = piles.size() - 1;
    while (left <= right) {
      int mid = (left + right) >>> 1;
      if (x.compareTo(piles.get(mid).peek()) < 0) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
