package LList;

import javax.swing.JOptionPane;

public class LListTest {
    public static void main(String[] args) {
        LList<String> list = new LList<>();
        boolean running = true;

        while (running) {
            String menu = "Choose an operation:\n" +
                         "1. Add to end\n" +
                         "2. Add at position\n" +
                         "3. Remove from position\n" +
                         "4. Replace at position\n" +
                         "5. Get entry at position\n" +
                         "6. Search for item\n" +
                         "7. Display list\n" +
                         "8. Get list length\n" +
                         "9. Check if empty\n" +
                         "10. Clear list\n" +
                         "11. Exit";

            String choice = JOptionPane.showInputDialog(menu);
            if (choice == null) {  // User clicked Cancel
                System.exit(0);
            }

            try {
                switch (choice) {
                    case "1":
                        String entry = JOptionPane.showInputDialog("Enter item to add:");
                        if (entry != null && !entry.trim().isEmpty()) {
                            list.add(entry);
                            JOptionPane.showMessageDialog(null, "Added: " + entry);
                        }
                        break;

                    case "2":
                        String posStr = JOptionPane.showInputDialog("Enter position:");
                        if (posStr != null && !posStr.trim().isEmpty()) {
                            int pos = Integer.parseInt(posStr);
                            entry = JOptionPane.showInputDialog("Enter item to add:");
                            if (entry != null && !entry.trim().isEmpty()) {
                                list.add(pos, entry);
                                JOptionPane.showMessageDialog(null, "Added: " + entry + " at position " + pos);
                            }
                        }
                        break;

                    case "3":
                        posStr = JOptionPane.showInputDialog("Enter position to remove:");
                        if (posStr != null && !posStr.trim().isEmpty()) {
                            int pos = Integer.parseInt(posStr);
                            String removed = list.remove(pos);
                            JOptionPane.showMessageDialog(null, "Removed: " + removed);
                        }
                        break;

                    case "4":
                        posStr = JOptionPane.showInputDialog("Enter position to replace:");
                        if (posStr != null && !posStr.trim().isEmpty()) {
                            int pos = Integer.parseInt(posStr);
                            entry = JOptionPane.showInputDialog("Enter new item:");
                            if (entry != null && !entry.trim().isEmpty()) {
                                String original = list.replace(pos, entry);
                                JOptionPane.showMessageDialog(null, "Replaced: " + original + " with " + entry);
                            }
                        }
                        break;

                    case "5":
                        posStr = JOptionPane.showInputDialog("Enter position:");
                        if (posStr != null && !posStr.trim().isEmpty()) {
                            int pos = Integer.parseInt(posStr);
                            String item = list.getEntry(pos);
                            JOptionPane.showMessageDialog(null, "Entry at position " + pos + ": " + item);
                        }
                        break;
                    case "6":
                        entry = JOptionPane.showInputDialog("Enter item to search:");
                        if (entry != null && !entry.trim().isEmpty()) {
                            int position = list.findPosition(entry);
                            if (position != -1) {
                                JOptionPane.showMessageDialog(null,
                                    "Item found in the list at position [" + position + "]");
                            } else {
                                JOptionPane.showMessageDialog(null, "Item not found in the list");
                            }
                        }
                        break;
                    case "7":
                        StringBuilder display = new StringBuilder("Current list:\n");
                        if (list.isEmpty()) {
                            display.append("List is empty");
                        } else {
                            Object[] array = list.toArray();
                            for (int i = 0; i < array.length; i++) {
                                display.append("Position ").append(i + 1).append(": ")
                                      .append(array[i]).append("\n");
                            }
                        }
                        JOptionPane.showMessageDialog(null, display.toString());
                        break;

                    case "8":
                        int length = list.getLength();
                        JOptionPane.showMessageDialog(null, "List length: " + length);
                        break;

                    case "9":
                        boolean empty = list.isEmpty();
                        JOptionPane.showMessageDialog(null, 
                            empty ? "List is empty" : "List is not empty");
                        break;

                    case "10":
                        list.clear();
                        JOptionPane.showMessageDialog(null, "List cleared");
                        break;

                    case "11":
                        running = false;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                }
            } catch (ListException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number format. Please enter a valid number.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
            }
        }
        System.exit(0);
    }
}