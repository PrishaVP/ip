import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class meowmeow {

    public static void main(String[] args) throws IOException {

        Saving saver = new Saving("./data/duke.txt");
        saver.getData();

        System.out.println("Hello! I'm meowmeow\n" + "What can I do for you?\n");

        ArrayList<Task> list = saver.getTaskList();

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        while (!input.equals("bye")) {
            if (input.equals("list")) {
                // Print all tasks
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + "." + list.get(i));
                }
            } else if (input.startsWith("mark ")) {
                // Mark a task as done
                int taskNumber = Integer.parseInt(input.substring(5)) - 1;
                if (taskNumber >= 0 && taskNumber < list.size()) {
                    list.get(taskNumber).markDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + list.get(taskNumber));
                    saver.saveData();
                } else {
                    System.out.println("Invalid task number.");
                }
            } else if (input.startsWith("unmark ")) {
                // Unmark a task (mark it as not done)
                int taskNumber = Integer.parseInt(input.substring(7)) - 1;
                if (taskNumber >= 0 && taskNumber < list.size()) {
                    list.get(taskNumber).unMark();
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  " + list.get(taskNumber));
                    saver.saveData();
                } else {
                    System.out.println("Invalid task number.");
                }
            } else if (input.startsWith("todo ")) {
                // Add a ToDo task
                String description = input.substring(5);
                ToDo todo = new ToDo(description);
                list.add(todo);
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + todo);
                System.out.println("Now you have " + list.size() + " tasks in the list.");
                saver.saveData();
            } else if (input.startsWith("deadline ")) {
                // Add a Deadline task
                String[] parts = input.substring(9).split(" /by ");
                if (parts.length <= 1) {
                    System.out.println("invalid deadline");
                } else {
                    String description = parts[0];
                    String by = parts[1];
                    Deadline deadline = new Deadline(description, by);
                    list.add(deadline);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + deadline);
                    System.out.println("Now you have " + list.size() + " tasks in the list.");
                    saver.saveData();
                }
            } else if (input.startsWith("event ")) {
                // Add an Event task
                String[] parts = input.substring(6).split(" /from | /to ");
                if (parts.length <= 1) {
                    System.out.println("invalid event");
                } else {
                    String description = parts[0];
                    String from = parts[1];
                    String to = parts[2];
                    Event event = new Event(description, from, to);
                    list.add(event);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + event);
                    System.out.println("Now you have " + list.size() + " tasks in the list.");
                    saver.saveData();
                }
            } else if (input.startsWith("delete ")) {
                // Delete a task
                int taskNumber = Integer.parseInt(input.substring(7)) - 1;
                if (taskNumber >= 0 && taskNumber < list.size()) {
                    Task removedTask = list.remove(taskNumber);
                    System.out.println("Noted. I've removed this task:");
                    System.out.println("  " + removedTask);
                    System.out.println("Now you have " + list.size() + " tasks in the list.");
                    saver.saveData();
                } else {
                    System.out.println("Invalid task number.");
                }
            } else {
                System.out.println("Sorry, I don't know what that means.");
            }
            input = s.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}