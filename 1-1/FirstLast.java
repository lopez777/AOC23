
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class FirstLast {
  public static void main(String[] args) {
    try {
      Scanner myReader = new Scanner(new File("input.txt"));
      int totalSum = 0;
      while(myReader.hasNextLine()) {
        String s = myReader.nextLine();
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
