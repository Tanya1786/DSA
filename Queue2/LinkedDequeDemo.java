package Queue2;

import javax.swing.JOptionPane;

public class LinkedDequeDemo {
    public static void main(String[] args) {
        LinkedDeque<String> deque = new LinkedDeque<>();
        boolean running = true;

        while (running) {
            String choiceStr = JOptionPane.showInputDialog(null, """
                    Choose an operation:
                    1. Add to Front
                    2. Add to Back
                    3. Remove Front
                    4. Remove Back
                    5. Get Front
                    6. Get Back
                    7. Is Empty
                    8. Clear
                    9. Display Deque
                    10. Exit
                    """);

            if (choiceStr == null) {
                // Cancel button was pressed or no input entered
                running = false;
                continue;
            }

            if (choiceStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No input entered. Please enter a number.");
                continue;
            }

            try {
                int choice = Integer.parseInt(choiceStr.trim());

                switch (choice) {
                    case 1 -> {
                        String newEntry = JOptionPane.showInputDialog("Enter a value to add to the front:");
                        if (newEntry != null) {
                            deque.addToFront(newEntry);
                            JOptionPane.showMessageDialog(null, newEntry + " has been added to the front.");
                        }
                    }
                    case 2 -> {
                        String newEntry = JOptionPane.showInputDialog("Enter a value to add to the back:");
                        if (newEntry != null) {
                            deque.addToBack(newEntry);
                            JOptionPane.showMessageDialog(null, newEntry + " has been added to the back.");
                        }
                    }
                    case 3 -> {
                        String frontValue = deque.removeFront();
                        JOptionPane.showMessageDialog(null, "Removed front value: " + frontValue);
                    }
                    case 4 -> {
                        String backValue = deque.removeBack();
                        JOptionPane.showMessageDialog(null, "Removed back value: " + backValue);
                    }
                    case 5 -> {
                        String frontValue = deque.getFront();
                        JOptionPane.showMessageDialog(null, "Front value: " + frontValue);
                    }
                    case 6 -> {
                        String backValue = deque.getBack();
                        JOptionPane.showMessageDialog(null, "Back value: " + backValue);
                    }
                    case 7 -> {
                        boolean isEmpty = deque.isEmpty();
                        JOptionPane.showMessageDialog(null, "Deque is " + (isEmpty ? "empty." : "not empty."));
                    }
                    case 8 -> {
                        deque.clear();
                        JOptionPane.showMessageDialog(null, "Deque has been cleared.");
                    }
                    case 9 -> {
                        deque.display();
                    }
                    case 10 -> running = false;
                    default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please select a number between 1 and 10.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            } catch (EmptyQueueException e) {
                JOptionPane.showMessageDialog(null, "Error: Deque is empty.");
            }
        }
    }
}
