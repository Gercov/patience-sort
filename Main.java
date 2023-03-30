import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    int[] sizes = { 100, 500, 1000, 5000, 10000 };
    for (int size : sizes) {
      List<Integer> list = readData(size);
      PatienceSortIterations.setCount(0);
      long startTime = System.nanoTime();
      PatienceSort.sort(list);
      long endTime = System.nanoTime();
      long duration = endTime - startTime;
      System.out
          .println("Size: " + size + ", Time: " + duration + " ns, Iterations: " + PatienceSortIterations.getCount());
    }
  }

  private static List<Integer> readData(int size) throws IOException {
    List<Integer> list = new ArrayList<>();
    BufferedReader bufferedReader = new BufferedReader(new FileReader("data_" + size + ".txt"));
    String line = bufferedReader.readLine();
    while (line != null) {
      list.add(Integer.parseInt(line));
      line = bufferedReader.readLine();
    }
    bufferedReader.close();
    return list;
  }
}
