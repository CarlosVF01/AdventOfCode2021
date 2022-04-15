package daythree;

import java.util.ArrayList;

import static utils.DataFiles.DAY3;
import static utils.Utils.*;

public class Day3 {
  public static void main(String[] args) {
    StringBuilder gammaBuilder = new StringBuilder();
    StringBuilder epsilonBuilder = new StringBuilder();

    ArrayList<String> binaryList = new ArrayList<>();
    readFileStrings(binaryList, DAY3.getFileName());

    int binaryNumbersSize = binaryList.get(0).length();

    StringBuilder lineStringBuilder = new StringBuilder();

    for (int i = 0; i < binaryNumbersSize; i++) {
      lineStringBuilder.setLength(0);

      for (String binary : binaryList) {
        lineStringBuilder.append(binary.charAt(i));
      }
      String binaryVerticalLine = lineStringBuilder.toString();
      Character key = maximumOcurringChar(binaryVerticalLine).getKey();
      gammaBuilder.append(key);
      epsilonBuilder.append(getReverseBinaryNumber(key.toString()));
    }

    String gamma = gammaBuilder.toString();
    String epsilon = epsilonBuilder.toString();
    System.out.println("Gamma binary value: " + gamma);
    System.out.println("Epsilon binary value: " + epsilon);

    int gammaIntValue = Integer.parseInt(gamma, 2);
    int epsilonIntValue = Integer.parseInt(epsilon, 2);

    System.out.println(gammaIntValue * epsilonIntValue);
  }
}
