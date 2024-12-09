package cheatsheet.Stack;

import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LinkedStackDemo {

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("""
                    Choose an operation:
                    1. Push
                    2. Pop
                    3. Peek
                    4. Is Empty
                    5. Clear
                    6. Print
                    7. Exit
                    """);

            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter a value to push onto the stack: ");
                        String newEntry = scanner.nextLine();
                        stack.push(newEntry);
                        System.out.println(newEntry + " has been pushed onto the stack.");
                    }
                    case 2 -> {
                        String poppedValue = stack.pop();
                        System.out.println("Popped value: " + poppedValue);
                    }
                    case 3 -> {
                        String topValue = stack.peek();
                        System.out.println("Top value: " + topValue);
                    }
                    case 4 -> {
                        boolean isEmpty = stack.isEmpty();
                        System.out.println("Stack is " + (isEmpty ? "empty." : "not empty."));
                    }
                    case 5 -> {
                        stack.clear();
                        System.out.println("Stack has been cleared.");
                    }
                    case 6 -> {
                        String stackContents = printStack(stack);
                        System.out.println("Stack contents:\n" + stackContents);
                    }
                    case 7 -> {
                        System.out.println("Bye");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Please select a number between 1 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
            } catch (EmptyStackException e) {
                System.out.println("Error: Stack is empty.");
            }
        }
        scanner.close();
    }

    private static String printStack(LinkedStack<String> stack) {
        LinkedStack<String> tempStack = new LinkedStack<>();
        StringBuilder stackContents = new StringBuilder();

        while (!stack.isEmpty()) {
            String data = stack.pop();
            stackContents.insert(0, data + "\n");
            tempStack.push(data); 
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return stackContents.toString();
    }
}
