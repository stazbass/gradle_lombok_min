import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FileContent {
  public static String readFile(String path) {
    StringBuffer result = new StringBuffer();
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(FileContent.class.getClassLoader().getResource(path).openStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        result.append(line);
        result.append('\n');
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result.toString();
  }
}
