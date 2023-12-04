
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class PartNumbers {
    public static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        int row = 0;
        char [][] engine = new char[140][140];
        
        try {
            Scanner myReader = new Scanner(new File("input.txt"));
            while(myReader.hasNextLine()) {
                String s = myReader.nextLine();
                for(int col = 0; col < s.length(); col++) {
                    engine[row][col] = s.charAt(col);
                }
                row++;
            }
            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            e.printStackTrace();
        }

        for(int k = 0; k < engine.length; k++) {
            for(int l = 0; l < engine[k].length; l++)
                System.out.print(engine[k][l]);
            System.out.println("");
        }
        StringBuilder number = new StringBuilder();
        boolean isValid = false;
        int sum = 0;
        int count = 0;

        for(int i = 0; i < 140; i++) {
            for(int j = 0; j < 140; j++) {
                if(Character.isDigit(engine[i][j])) {
                    number.append(engine[i][j]);
                    if(checkSurroundings(engine, i, j)) {
                        isValid = true;
                    }
                } 
                else {
                    if(isValid) {
                        result.add(number.toString());
                        isValid = false;
                    }
                    number = new StringBuilder();
                }
            }
        }
        for(String numAsString : result) {
            sum += Integer.parseInt(numAsString);
        }
        System.out.println(sum);
    }

    private static boolean checkSurroundings(char[][] list, int x, int y) {
        for(int dx = -1; dx <= 1; dx++) {
            if((x + dx >= 0) && (x + dx < 140)) {
                for(int dy = -1; dy <= 1; dy++) {
                    if((y + dy >= 0) && (y + dy < 140) && (!(dx == 0 && dy == 0))) {
                        if (Character.toString(list[x + dx][y + dy]).matches("[^a-zA-Z0-9.]")) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
