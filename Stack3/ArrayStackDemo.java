package cheatsheet.Stack;

import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            // Define the menu options
            System.out.println("Choose Stack Operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Is Empty");
            System.out.println("5. Clear");
            System.out.println("6. Print");
            System.out.println("7. Exit");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1: // Push
                        System.out.print("Enter element to push: ");
                        String input = scanner.nextLine();
                        stack.push(input);
                        System.out.println(input + " pushed onto the stack.");
                        break;
                    case 2: // Pop
                        String poppedElement = stack.pop();
                        System.out.println("Popped: " + poppedElement);
                        break;
                    case 3: // Peek
                        String topElement = stack.peek();
                        System.out.println("Top element: " + topElement);
                        break;
                    case 4: // Is Empty
                        System.out.println("Is Empty: " + stack.isEmpty());
                        break;
                    case 5: // Clear
                        stack.clear();
                        System.out.println("Stack cleared.");
                        break;
                    case 6: // Print
                        System.out.println(stack.toString());
                        break;
                    case 7: // Exit
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a number between 1 and 7.");
                        break;
                }
            } catch (EmptyStackException e) {
                System.out.println("Stack is empty. Cannot perform this operation.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // consume invalid input
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Close the scanner
        scanner.close();
    }
}
