import java.util.Scanner;

public class Battleship {
    public static void main(String args[]) {

        int position;
        String firstPlayerName;
        String secondPlayerName;
        Scanner keyboard = new Scanner(System.in);
        String[][] tableFirstPlayer = new String[5][5];
        String[][] tableSecondPlayer = new String[5][5];
        String[][] tableFirstPlayerUi = new String[5][5];
        String[][] tableSecondPlayerUi = new String[5][5];
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;
        int[] separateLines = new int[100];


        System.out.println("Welcome to Battleship game!");

        System.out.println("Set name for player 1:");
        firstPlayerName = keyboard.nextLine();

        System.out.println("Set name for player 2:");
        secondPlayerName = keyboard.nextLine();

        tableFirstPlayer = BattleshipGameMethods.InsertShipsOnTable(tableFirstPlayer, firstPlayerName);
        System.out.println("This is " + firstPlayerName + " Table:");
        BattleshipGameMethods.Print2D(tableFirstPlayer);

        for (int space: separateLines) {
            System.out.println("-");
        }

        tableSecondPlayer = BattleshipGameMethods.InsertShipsOnTable(tableSecondPlayer, secondPlayerName);
        System.out.println("This is " + secondPlayerName + " Table:");
        BattleshipGameMethods.Print2D(tableSecondPlayer);

        for (int space: separateLines) {
            System.out.println("-");
        }

        while (true) {

            if (firstPlayerScore == 5) {
                System.out.println("WE HAVE A WINNER!! " + "Player: " + firstPlayerName + " IS THE KING");
                BattleshipGameMethods.Print2D(tableSecondPlayerUi);
                break;
            } else if (secondPlayerScore == 5) {
                System.out.println("WE HAVE A WINNER!! " + "Player: " + secondPlayerName + " IS THE KING");
                BattleshipGameMethods.Print2D(tableFirstPlayerUi);
                break;
            }

           
            tableSecondPlayerUi = BattleshipGameMethods.ShotingToPlayerTable(tableSecondPlayer, tableSecondPlayerUi, firstPlayerName);
            firstPlayerScore = BattleshipGameMethods.PlayerScore(tableSecondPlayerUi);
            BattleshipGameMethods.Print2D(tableSecondPlayerUi);
            System.out.println("Score value for " + firstPlayerName + " is: " + firstPlayerScore);
            
            tableFirstPlayerUi = BattleshipGameMethods.ShotingToPlayerTable(tableFirstPlayer, tableFirstPlayerUi, secondPlayerName);
            secondPlayerScore = BattleshipGameMethods.PlayerScore(tableFirstPlayerUi);
            BattleshipGameMethods.Print2D(tableFirstPlayerUi);
            System.out.println("Score value for " + secondPlayerName + " is: " + secondPlayerScore);
        }
    }
}