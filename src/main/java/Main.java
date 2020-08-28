import ca.wfaria.hangman.GameManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in).useDelimiter("\n")) {

            String playAgain = "y";
            while ("y".equalsIgnoreCase(playAgain)) {

                GameManager gameManager = new GameManager(sc);
                gameManager.start();

                System.out.println("Do you want to play again (y/n)?");
                playAgain = sc.next();
            }

            System.out.println(">>>> Bye <<<<");

        }
    }
}
