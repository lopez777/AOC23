
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class FirstLast {
  public static void main(String[] args) {
    try {
      Scanner myReader = new Scanner(new File("input.txt"));
      int totalSum = 0;
      Map<String, String> writtenNumbers = new HashMap<>();
      writtenNumbers.put("one", "1");
      writtenNumbers.put("two", "2");
      writtenNumbers.put("three", "3");
      writtenNumbers.put("four", "4");
      writtenNumbers.put("five", "5");
      writtenNumbers.put("six", "6");
      writtenNumbers.put("seven", "7");
      writtenNumbers.put("eight", "8");
      writtenNumbers.put("nine", "9");

      while(myReader.hasNextLine()) {
        String s = myReader.nextLine();

        // replace writtenNumbers with numeric string equivalent
        System.out.println(s);
        for(Map.Entry<String, String> entry : writtenNumbers.entrySet())
          s = s.replace(entry.getKey(), entry.getValue());
        System.out.println(s);

        boolean isFirst = true;
        char firstDigit = Character.MIN_VALUE;
        Stack<Character> digits = new Stack<>();
        for(char c : s.toCharArray()) {
          if(Character.isDigit(c)) {
            if(isFirst) {
              firstDigit = c;
              isFirst = false;
            }  
            digits.push(c);
          }
        }
        totalSum += Integer.parseInt("" + firstDigit + digits.pop());
      }
      System.out.println(totalSum);
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("FILE NOT FOUND");
      e.printStackTrace();
    }
  }
}
