package meowmeow;

import java.util.Scanner;

public class Ui {

    private static Scanner scanner;
    private static String input;

    public Ui(){
        Ui.scanner = new Scanner(System.in);
    }

    public static String start() {
        System.out.println("Hello! I'm MeowMeow\n" + "What can I do for you?\n");
        input = scanner.nextLine();
        return input;

    }

    public static String getNext() {
        input = scanner.nextLine();
        return input;
    }
}