package partAandB;
import javax.swing.JOptionPane;

/**
 * A demo program for the MyDeque class using JOptionPane for user input.
 */
public class MyLinkedDequeDemo {
    private static MyDeque<Integer> deque = new MyDeque<>();

    /**
     * The main method for the demo program
     * @param args the command-line arguments 
     */
    public static void main(String[] args) {
        while (true) {
            try {
                String choice = showMenu();
                if (choice == null) {
                    break; 
                }
                processChoice(choice);
            } catch (EmptyDequeException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (InvalidInputException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Displays the menu and gets the user's selection.
     * @return the user's choice as a string
     */
    private static String showMenu() {
        return JOptionPane.showInputDialog(null,
            "Choose an operation:\n1. Add to Front\n2. Add to Back\n3. Remove from Front\n" +
            "4. Remove from Back\n5. View Front\n6. View Back\n" +
            "7. Check if Empty\n8. Clear Deque\n9. Exit", "Deque Operations", JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Processes the user choice 
     * @param choice the user's choice
     * @throws EmptyDequeException if a deque is empty
     * @throws InvalidInputException if user input is invalid
     */
    private static void processChoice(String choice) throws EmptyDequeException, InvalidInputException {
        try {
            int option = Integer.parseInt(choice);
            switch (option) {
                case 1 -> addToFront();
                case 2 -> addToBack();
                case 3 -> removeFromFront();
                case 4 -> removeFromBack();
                case 5 -> viewFront();
                case 6 -> viewBack();
                case 7 -> checkEmpty();
                case 8 -> clearDeque();
                case 9 -> System.exit(0);
                default -> throw new InvalidInputException("No such option. Please choose a number between 1-9.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a valid number.");
        }
    }

    /**
     * Adds a new entry to the front of the deque.
     * @throws InvalidInputException if the input is invalid
     */
    private static void addToFront() throws InvalidInputException {
        try {
            String input = JOptionPane.showInputDialog(null, "Enter a number to add to front:", "Add to Front", JOptionPane.QUESTION_MESSAGE);
            if (input == null) return;
            int value = Integer.parseInt(input);
            deque.addToFront(value);
            JOptionPane.showMessageDialog(null, value + " added to front.");
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter an integer.");
        }
    }

    /**
     * Adds a new entry to the back of the deque.
     * @throws InvalidInputException if the input is invalid
     */
    private static void addToBack() throws InvalidInputException {
        try {
            String input = JOptionPane.showInputDialog(null, "Enter an integer to add to back:", 
                "Add to Back", JOptionPane.QUESTION_MESSAGE);
            if (input == null) return;
            int value = Integer.parseInt(input);
            deque.addToBack(value);
            JOptionPane.showMessageDialog(null, value + " added to back.");
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter an integer.");
        }
    }

    /**
     * Removes the front entry from the deque.
     * @throws EmptyDequeException if the deque is empty
     */
    private static void removeFromFront() throws EmptyDequeException {
        if (deque.isEmpty()) {
            throw new EmptyDequeException("Can't remove. Empty deque.");
        }
        int removed = deque.removeFront();
        JOptionPane.showMessageDialog(null, removed + " removed from front.");
    }

    /**
     * Removes the back entry from the deque.
     * @throws EmptyDequeException if the deque is empty
     */
    private static void removeFromBack() throws EmptyDequeException {
        if (deque.isEmpty()) {
            throw new EmptyDequeException("Can't remove. Empty deque.");
        }
        int removed = deque.removeBack();
        JOptionPane.showMessageDialog(null, removed + " removed from back.");
    }

    /**
     * Retrieves the front entry of the deque.
     * @throws EmptyDequeException if the deque is empty
     */
    private static void viewFront() throws EmptyDequeException {
        if (deque.isEmpty()) {
            throw new EmptyDequeException("Deque is empty.");
        }
        JOptionPane.showMessageDialog(null, "Front element: " + deque.getFront());
    }
    /**
     * Retrieves the back entry of the deque.
     * @throws EmptyDequeException if the deque is empty
     */
    private static void viewBack() throws EmptyDequeException {
        if (deque.isEmpty()) {
            throw new EmptyDequeException("Deque is empty.");
        }
        JOptionPane.showMessageDialog(null, "Back element: " + deque.getBack());
    }
    /**
     * Checks if the deque is empty.
     */
    private static void checkEmpty() {
        String message = deque.isEmpty() ? "Deque is empty." : "Deque is not empty.";
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Clears all entries from the deque.
     */
    private static void clearDeque() {
        deque.clear();
        JOptionPane.showMessageDialog(null, "Deque cleared.");
    }
}
