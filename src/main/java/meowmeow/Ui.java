package meowmeow;

import java.util.Scanner;

public class Ui {

    private static Scanner s;
    private static String input;

    public Ui(){
        Ui.s = new Scanner(System.in);
    }

    public static String start() {
        System.out.println("Hello! I'm meowmeow.meowmeow\n" + "What can I do for you?\n");
        input = s.nextLine();
        return input;

    }

    public static String next() {
        input = s.nextLine();
        return input;
    }
}