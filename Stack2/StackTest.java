package Stack2;

import javax.swing.JOptionPane;
import java.util.EmptyStackException;

public class StackTest {
   public static void main(String[] args) {
       StackInterface<String> stack = new ArrayStack<>();
       boolean quit = false;
       
       while (!quit) {
           String menu = "Choose an option:\n"
                       + "1. Push\n"
                       + "2. Pop\n"
                       + "3. Peek\n"
                       + "4. Check if Empty\n"
                       + "5. Clear\n"
                       + "6. Quit";
           String choice = JOptionPane.showInputDialog(menu);
           
           switch (choice) {
               case "1":
                   String newEntry = JOptionPane.showInputDialog("Enter item to push:");
                   stack.push(newEntry);
                   JOptionPane.showMessageDialog(null, "Item pushed: " + newEntry);
                   break;
               case "2":
                   try {
                       String poppedItem = stack.pop();
                       JOptionPane.showMessageDialog(null, "Item popped: " + poppedItem);
                   } catch (EmptyStackException e) {
                       JOptionPane.showMessageDialog(null, "Stack is empty!", "Error", JOptionPane.ERROR_MESSAGE);
                   }
                   break;
               case "3":
                   try {
                       String topItem = stack.peek();
                       JOptionPane.showMessageDialog(null, "Top item: " + topItem);
                   } catch (EmptyStackException e) {
                       JOptionPane.showMessageDialog(null, "Stack is empty!", "Error", JOptionPane.ERROR_MESSAGE);
                   }
                   break;
               case "4":
                   JOptionPane.showMessageDialog(null, "Stack is " + (stack.isEmpty() ? "empty" : "not empty"));
                   break;
               case "5":
                   stack.clear();
                   JOptionPane.showMessageDialog(null, "Stack cleared.");
                   break;
               case "6":
                   quit = true;
                   break;
               default:
                   JOptionPane.showMessageDialog(null, "Invalid option! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                   break;
           }
       }
   }
} // end StackTest
