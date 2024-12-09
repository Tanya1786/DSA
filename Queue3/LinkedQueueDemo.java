package Queue3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LinkedQueueDemo {
    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("""
                    Choose an operation:
                    1. Enqueue
                    2. Dequeue
                    3. Get Front
                    4. Is Empty
                    5. Clear
                    6. Print Queue
                    7. Exit
                    """);

            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter a value to enqueue: ");
                        String newEntry = scanner.nextLine();
                        queue.enqueue(newEntry);
                        System.out.println(newEntry + " has been enqueued.");
                    }
                    case 2 -> {
                        String dequeuedValue = queue.dequeue();
                        System.out.println("Dequeued value: " + dequeuedValue);
                    }
                    case 3 -> {
                        String frontValue = queue.getFront();
                        System.out.println("Front value: " + frontValue);
                    }
                    case 4 -> {
                        boolean isEmpty = queue.isEmpty();
                        System.out.println("Queue is " + (isEmpty ? "empty." : "not empty."));
                    }
                    case 5 -> {
                        queue.clear();
                        System.out.println("Queue has been cleared.");
                    }
                    case 6 -> {
                        queue.printQueue();
                    }
                    case 7 -> {
                        System.out.println("Exiting...");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Please select a number between 1 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
            } catch (EmptyQueueException e) {
                System.out.println("Error: Queue is empty.");
            }
        }

        scanner.close();
    }
}
