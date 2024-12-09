package Stack;

import javax.swing.JOptionPane;

public class StackTest 
{
    public static void main(String[] args) 
    {
        Stack<String> stack = new Stack<>();
        
        while (true) 
        {
            String menu = "Stack Operations:\n" +
                          "1. Push\n" +
                          "2. Pop\n" +
                          "3. Peek\n" +
                          "4. Display\n" +
                          "5. Clear\n" +
                          "6. Is Empty\n" +
                          "7. Exit\n\n" +
                          "Choose a number (1-7):";
            
            String input = JOptionPane.showInputDialog(null, menu, "Stack Menu", JOptionPane.QUESTION_MESSAGE);
            
            // Check if user cancelled or closed the dialog
            if (input == null) 
            {
                System.exit(0);
            }
            
            try 
            {
                int choice = Integer.parseInt(input);
                
                switch (choice) 
                {
                    case 1: // Push
                        String item = JOptionPane.showInputDialog("Enter item to push:");
                        if (item != null && !item.trim().isEmpty()) 
                        {
                            stack.push(item);
                            JOptionPane.showMessageDialog(null, "Pushed: " + item);
                        }
                        break;
                    
                    case 2: // Pop
                        if (!stack.isEmpty()) 
                        {
                            String poppedItem = stack.pop();
                            JOptionPane.showMessageDialog(null, "Popped: " + poppedItem);
                        } 
                        else 
                        {
                            JOptionPane.showMessageDialog(null, "Stack is empty!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    
                    case 3: // Peek
                        if (!stack.isEmpty()) 
                        {
                            String topItem = stack.peek();
                            JOptionPane.showMessageDialog(null, "Top item: " + topItem);
                        } 
                        else 
                        {
                            JOptionPane.showMessageDialog(null, "Stack is empty!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    
                    case 4: // Display
                        if (!stack.isEmpty()) 
                        {
                            StringBuilder displayText = new StringBuilder("Stack contents (top to bottom):\n");
                            for (int i = stack.getSize() - 1; i >= 0; i--) 
                            {
                                displayText.append(stack.get(i)).append("\n");
                            }
                            JOptionPane.showMessageDialog(null, displayText.toString(), "Stack Contents", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else 
                        {
                            JOptionPane.showMessageDialog(null, "Stack is empty!", "Stack Contents", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    
                    case 5: // Clear
                        stack.clear();
                        JOptionPane.showMessageDialog(null, "Stack cleared");
                        break;
                    
                    case 6: // Is Empty
                        JOptionPane.showMessageDialog(null, "Stack is " + (stack.isEmpty() ? "empty" : "not empty"));
                        break;
                    
                    case 7: // Exit
                        System.exit(0);
                    
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please enter a number between 1 and 7.", 
                                                     "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.", 
                                             "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch (EmptyStackException e) 
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}