package ca.wfaria.hangman;

public class ConsoleUtil {

    public static void clearScreen() {
        try {
            new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            throw new IllegalStateException("An error happened. Restart the game");
        }
    }
}
