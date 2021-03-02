import java.util.Scanner;
import java.util.*;

public class BattleshipGameMethods {

    public static String[][] InsertShipsOnTable(String[][] testArray, String playerName) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("IMPORTANT: Table is 5 x 5. you can set values from 0 to 4...");
        System.out.println("IMPORTANT: entered coorditante will be separated by a whitespace like: " +"0 3");
        System.out.println(playerName + " Enter your ships' coordinates:");
        int ships = 0;
        String coordinateValue;

        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {
                testArray[i][j] = "-";
            }
        }
        do {
            System.out.println("Ship N°" + (ships + 1) + ":");
            coordinateValue = keyboard.nextLine();
            int firstItem = Integer.parseInt(coordinateValue.substring(0, 1));
            int secondItem = Integer.parseInt(coordinateValue.substring(2, 3));
            if (firstItem <= 4 && secondItem <= 4 && testArray[firstItem][secondItem] != "@") {
                testArray[firstItem][secondItem] = "@";
                ships += 1;
            } else if (firstItem > 4 || secondItem > 4) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            } else if (testArray[firstItem][secondItem] == "-") {
                System.out.println("You already have a ship there. Choose different coordinates.");
            }

        } while (ships != 5);
        return testArray;
    }

    public static void Print2D(String mat[][]) {
        for (String[] row: mat)
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }

    public static String[][] ShotingToPlayerTable(String[][] tableValue, String[][] iu, String playername) {
        Scanner keyboard = new Scanner(System.in);
        String coordinateValue;
        boolean shotDone = false;

        for (int i = 0; i < iu.length; i++) {
            for (int j = 0; j < iu[i].length; j++) {
                if (iu[i][j] == "X") {
                    iu[i][j] = "X";
                } else if (iu[i][j] == "O") {
                    iu[i][j] = "O";
                } else {
                    iu[i][j] = "-";
                }
            }
        }

        do {
            System.out.println(playername + " Enter hit row/column:");
            coordinateValue = keyboard.nextLine();
            int firstItem = Integer.parseInt(coordinateValue.substring(0, 1));
            int secondItem = Integer.parseInt(coordinateValue.substring(2, 3));
     
            if ((firstItem > 4 && firstItem < 0) || (secondItem > 4 && secondItem < 0)) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            } else if (iu[firstItem][secondItem] == "X" || iu[firstItem][secondItem] == "O") {
                System.out.println("You already have shot there. Choose different coordinates.");
            } else if (tableValue[firstItem][secondItem] != "@") {
                iu[firstItem][secondItem] = "O";
                shotDone = true;
            } else if (tableValue[firstItem][secondItem] == "@") {
                iu[firstItem][secondItem] = "X";
                shotDone = true;
            }

        } while (!shotDone);
        return iu;
    }

    public static int PlayerScore(String[][] uiTable) {
        int scoreValue = 0;
        for (int i = 0; i < uiTable.length; i++) {
            for (int j = 0; j < uiTable[i].length; j++) {
                if (uiTable[i][j] == "X") {
                    scoreValue++;
                }
            }
        }
        return scoreValue;
    }

}