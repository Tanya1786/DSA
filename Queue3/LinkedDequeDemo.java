package cheatsheet.Queue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LinkedDequeDemo {
    public static void main(String[] args) {
        LinkedDeque<String> deque = new LinkedDeque<>();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            // Display the menu options
            System.out.println("""
                    Choose an operation:
                    1. Add to Front
                    2. Add to Back
                    3. Remove Front
                    4. Remove Back
                    5. Get Front
                    6. Get Back
                    7. Is Empty
                    8. Clear
                    9. Print Deque
                    10. Exit
                    """);

            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter a value to add to the front: ");
                        String newEntry = scanner.nextLine();
                        deque.addToFront(newEntry);
                        System.out.println(newEntry + " has been added to the front.");
                    }
                    case 2 -> {
                        System.out.print("Enter a value to add to the back: ");
                        String newEntry = scanner.nextLine();
                        deque.addToBack(newEntry);
                        System.out.println(newEntry + " has been added to the back.");
                    }
                    case 3 -> {
                        String frontValue = deque.removeFront();
                        System.out.println("Removed front value: " + frontValue);
                    }
                    case 4 -> {
                        String backValue = deque.removeBack();
                        System.out.println("Removed back value: " + backValue);
                    }
                    case 5 -> {
                        String frontValue = deque.getFront();
                        System.out.println("Front value: " + frontValue);
                    }
                    case 6 -> {
                        String backValue = deque.getBack();
                        System.out.println("Back value: " + backValue);
                    }
                    case 7 -> {
                        boolean isEmpty = deque.isEmpty();
                        System.out.println("Deque is " + (isEmpty ? "empty." : "not empty."));
                    }
                    case 8 -> {
                        deque.clear();
                        System.out.println("Deque has been cleared.");
                    }
                    case 9 -> {
                        String dequeContents = printDeque(deque);
                        System.out.println("Deque contents:\n" + dequeContents);
                    }
                    case 10 -> {
                        System.out.println("Exiting...");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Please select a number between 1 and 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // consume invalid input
            } catch (EmptyQueueException e) {
                System.out.println("Error: Deque is empty.");
            }
        }

        // Close the scanner
        scanner.close();
    }

    // Helper method to print the deque without modifying it
    private static String printDeque(LinkedDeque<String> deque) {
        StringBuilder dequeContents = new StringBuilder();

        try {
            while (!deque.isEmpty()) {
                String data = deque.removeFront();
                dequeContents.append(data).append("\n");
                deque.addToBack(data); // Add back to preserve the original order
            }
        } catch (EmptyQueueException e) {
            // This should not happen as we are using isEmpty() check
        }

        return dequeContents.toString().trim();
    }
}
