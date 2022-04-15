package utils;

import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Class with methods and parameters that are useful for the other classes */
public final class Utils {

  /** Private constructor to avoid being able to initialitze this class somewhere */
  private Utils() {}

  private static final String RESOURCE_PATH = "/src/main/resources/data/";
  private static final String DIRECTORY_PATH = System.getProperty("user.dir");
  public static final String RESOURCE_DIRECTORY = DIRECTORY_PATH + RESOURCE_PATH;

  public static final String ONE_SPACE_STRING = " ";

  /**
   * Reads each line of a txt file and adds them into a list of numbers.
   *
   * @param list list of numbers
   */
  public static void readFileNumbers(List<Integer> list, String dataFileName) {
    File file = new File(RESOURCE_DIRECTORY + dataFileName);

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String text;

      while ((text = reader.readLine()) != null) {
        list.add(Integer.parseInt(text));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Reads each line of a txt file and adds them into a list of strings.
   *
   * @param list list of strings
   */
  public static void readFileStrings(List<String> list, String dataFileName) {
    File file = new File(RESOURCE_DIRECTORY + dataFileName);

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String text;

      while ((text = reader.readLine()) != null) {
        list.add(text);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Returns a pair {@link Pair} of the character that appears the most and the times it appears. I
   * just found out about this class from apache commons and wanted to try it out.
   *
   * @param str string to check
   * @return {@link Pair}
   */
  public static Pair<Character, Long> maximumOcurringChar(String str) {
    return str
        .chars()
        .filter(c -> !Character.isWhitespace(c)) // ignoring space
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .map(p -> Pair.of(p.getKey(), p.getValue()))
        .orElse(Pair.of(Character.MIN_VALUE, -1L));
  }

  public static String getReverseBinaryNumber(String s) {
    return s.equals("0") ? "1" : "0";
  }
}
