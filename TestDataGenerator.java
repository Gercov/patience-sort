import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestDataGenerator {

  public static void main(String[] args) throws IOException {
    int[] sizes = { 100, 500, 1000, 5000, 10000 };
    for (int size : sizes) {
      generateRandomData(size);
    }
  }

  private static void generateRandomData(int size) throws IOException {
    Random random = new Random();
    FileWriter fileWriter = new FileWriter("data_" + size + ".txt");
    for (int i = 0; i < size; i++) {
      fileWriter.write(random.nextInt(size) + "\n");
    }
    fileWriter.close();
  }
}
