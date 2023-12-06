
import java.io.*;
import java.util.*;

public class WinningNumbers {
    public static void main(String[] args) {
        try {
            Scanner myReader = new Scanner(new File("input.txt"));
            int totalPoints = 0;

            while(myReader.hasNextLine()) {
                String s = myReader.nextLine();
                int count = -1; // first element in both arrays will always equal true ""=""
                String[] winningNums = s.split("\\:")[1].split("\\|")[0].split("\\s+");
                String[] myNums = s.split("\\|")[1].split("\\s+");

                for(String wn : winningNums) {
                    for(String mn : myNums) {
                        if(wn.equals(mn))  {
                            count++;
                            break;
                        }
                    }
                }
                if(count > 0) totalPoints += Math.pow(2, count - 1);
            }

            System.out.println(totalPoints);
            myReader.close();
        } catch (FileNotFoundException e) {
                System.out.println("FILE NOT FOUND");
                e.printStackTrace();
        }
    }
}
