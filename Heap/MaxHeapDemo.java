package Heap;

import java.util.Scanner;

public class MaxHeapDemo {
    public static void main(String[] args) {
        MaxHeap<String> heap = new MaxHeap<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("""
                    Choose an operation:
                    1. Add
                    2. Remove Max
                    3. Get Max
                    4. Is Empty
                    5. Get Size
                    6. Clear
                    7. Display
                    8. Exit
                    """);
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter a value to add: ");
                        String newEntry = scanner.nextLine();
                        heap.add(newEntry);
                        System.out.println(newEntry + " has been added.");
                    }
                    case 2 -> {
                        String maxValue = heap.removeMax();
                        if (maxValue != null) {
                            System.out.println("Removed max value: " + maxValue);
                        }
                    }
                    case 3 -> {
                        String maxValue = heap.getMax();
                        if (maxValue != null) {
                            System.out.println("Max value: " + maxValue);
                        }
                    }
                    case 4 -> {
                        boolean isEmpty = heap.isEmpty();
                        System.out.println("Heap is " + (isEmpty ? "empty." : "not empty."));
                    }
                    case 5 -> {
                        int size = heap.getSize();
                        System.out.println("Heap size: " + size);
                    }
                    case 6 -> {
                        heap.clear();
                        System.out.println("Heap has been cleared.");
                    }
                    case 7 -> {
                        heap.display();
                    }
                    case 8 -> {
                        running = false;
                        System.out.println("Exiting the program.");
                    }
                    default -> System.out.println("Invalid choice. Please select a number between 1 and 8.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
            }
        }
        
        scanner.close();
    }
}