package Heap;

import javax.swing.JOptionPane;

public class MaxHeapDemo {
    public static void main(String[] args) {
        MaxHeap<String> heap = new MaxHeap<>();
        boolean running = true;

        while (running) {
            String choiceStr = JOptionPane.showInputDialog(null, """
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
                        String newEntry = JOptionPane.showInputDialog("Enter a value to add:");
                        if (newEntry != null) {
                            heap.add(newEntry);
                            JOptionPane.showMessageDialog(null, newEntry + " has been added.");
                        }
                    }
                    case 2 -> {
                        String maxValue = heap.removeMax();
                        if (maxValue != null) {
                            JOptionPane.showMessageDialog(null, "Removed max value: " + maxValue);
                        }
                    }
                    case 3 -> {
                        String maxValue = heap.getMax();
                        if (maxValue != null) {
                            JOptionPane.showMessageDialog(null, "Max value: " + maxValue);
                        }
                    }
                    case 4 -> {
                        boolean isEmpty = heap.isEmpty();
                        JOptionPane.showMessageDialog(null, "Heap is " + (isEmpty ? "empty." : "not empty."));
                    }
                    case 5 -> {
                        int size = heap.getSize();
                        JOptionPane.showMessageDialog(null, "Heap size: " + size);
                    }
                    case 6 -> {
                        heap.clear();
                        JOptionPane.showMessageDialog(null, "Heap has been cleared.");
                    }
                    case 7 -> {
                        heap.display();
                    }
                    case 8 -> running = false;
                    default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please select a number between 1 and 8.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            }
        }
    }
}
