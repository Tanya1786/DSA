package Queue;

import javax.swing.JOptionPane;

public class CircularArrayQueueDemo {
    public static void main(String[] args) {
        CircularArrayQueue<String> queue = new CircularArrayQueue<>();
        boolean running = true;

        while (running) {
            String menu = """
                    Choose an operation:
                    1. Enqueue
                    2. Dequeue
                    3. Get Front
                    4. Get Back
                    5. Is Empty
                    6. Clear
                    7. Display Queue
                    8. Exit
                    """;

            String choiceStr = JOptionPane.showInputDialog(menu);
            if (choiceStr == null) break;

            try {
                int choice = Integer.parseInt(choiceStr);

                switch (choice) {
                    case 1 -> {
                        String newEntry = JOptionPane.showInputDialog("Enter a value to enqueue:");
                        if (newEntry != null) {
                            queue.addToBack(newEntry);
                            JOptionPane.showMessageDialog(null, newEntry + " has been enqueued.");
                        }
                    }
                    case 2 -> {
                        String dequeuedValue = queue.removeFront();
                        JOptionPane.showMessageDialog(null, "Dequeued value: " + dequeuedValue);
                    }
                    case 3 -> {
                        String frontValue = queue.getFront();
                        JOptionPane.showMessageDialog(null, "Front value: " + frontValue);
                    }
                    case 4 -> {
                        String backValue = queue.getBack();
                        JOptionPane.showMessageDialog(null, "Back value: " + backValue);
                    }
                    case 5 -> {
                        boolean isEmpty = queue.isEmpty();
                        JOptionPane.showMessageDialog(null, "Queue is " + (isEmpty ? "empty." : "not empty."));
                    }
                    case 6 -> {
                        queue.clear();
                        JOptionPane.showMessageDialog(null, "Queue has been cleared.");
                    }
                    case 7 -> {
                        String queueContents = queue.toString();
                        JOptionPane.showMessageDialog(null, "Queue contents:\n" + queueContents);
                    }
                    case 8 -> running = false;
                    default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please select a number between 1 and 8.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (EmptyQueueException e) {
                JOptionPane.showMessageDialog(null, "Error: Queue is empty.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
