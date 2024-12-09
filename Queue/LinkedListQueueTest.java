package Queue;

import javax.swing.JOptionPane;

public class LinkedListQueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedListQueue<>();
        
        while (true) {
            try {
                String menu = "Linked List Queue Operations:\n" +
                             "1. Enqueue\n" +
                             "2. Dequeue\n" +
                             "3. Peek\n" +
                             "4. Size\n" +
                             "5. Display Queue\n" +
                             "6. Exit\n\n" +
                             "Enter your choice (1-6):";
                
                String choiceStr = JOptionPane.showInputDialog(null, menu);
                
                if (choiceStr == null) {
                    System.exit(0);
                }
                
                try {
                    int choice = Integer.parseInt(choiceStr.trim());
                    
                    switch (choice) {
                        case 1: // Enqueue
                            String element = JOptionPane.showInputDialog("Enter element to enqueue:");
                            if (element != null && !element.trim().isEmpty()) {
                                queue.enqueue(element);
                                JOptionPane.showMessageDialog(null, "Element enqueued successfully!" );
                            }
                            break;

                        case 2: // Dequeue
                            String removed = queue.dequeue();
                            JOptionPane.showMessageDialog(null, 
                                "Dequeued element: " + removed);
                            break;

                        case 3: // Peek
                            String front = queue.peek();
                            JOptionPane.showMessageDialog(null, 
                                "Front element: " + front);
                            break;

                        case 4: // Size
                            JOptionPane.showMessageDialog(null, 
                                "Current queue size: " + queue.size());
                            break;

                        case 5: // Display Queue
                            JOptionPane.showMessageDialog(null, queue.displayQueue());
                            break;

                        case 6: // Exit
                            System.exit(0);
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, 
                                "Invalid choice! Please enter a number between 1 and 6.",
                                "Invalid Input",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, 
                        "Please enter a valid number!",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (QueueFullException e) {
                JOptionPane.showMessageDialog(null, 
                    "Error: " + e.getMessage(), 
                    "Queue Full", 
                    JOptionPane.ERROR_MESSAGE);
            } catch (QueueEmptyException e) {
                JOptionPane.showMessageDialog(null, 
                    "Error: " + e.getMessage(), 
                    "Queue Empty", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}