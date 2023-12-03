
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class ValidGames {
    public static void main(String[] args) {
        try {
            Scanner myReader = new Scanner(new File("input.txt"));
            int sumIDs = 0;
            final int redLimit = 12;
            final int greenLimit = 13;
            final int blueLimit = 14;

            while(myReader.hasNextLine()) {
                String s = myReader.nextLine();
                boolean limitPassed = false;
                int id = Integer.parseInt(s.split("\\:")[0].replace("Game ", ""));
                String[] sets = s.split("\\:")[1].split(";");

                for(String set : sets) {
                    String[] cubes = set.split("\\,");
                    for(String cube : cubes) {
                        String color = cube.split("\\s+")[2];
                        if(color.equals("red") && Integer.parseInt(cube.split("\\s+")[1]) > 12) limitPassed = true;
                        else if(color.equals("green") && Integer.parseInt(cube.split("\\s+")[1]) > 13) limitPassed = true;
                        else if(color.equals("blue") && Integer.parseInt(cube.split("\\s+")[1]) > 14) limitPassed = true;
                    }
                }
                if(!limitPassed) sumIDs += id;
            }

            System.out.println(sumIDs);
            myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("FILE NOT FOUND");
                e.printStackTrace();
    }
    }
}
