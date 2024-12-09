package partAandB;

import javax.swing.JOptionPane;

/**
 * A program that checks if an expression has balanced delimiters using a deque.
 */
public class IfBalanceExp {
    private static MyDeque<Character> deque = new MyDeque<>();
    /**
     * The main method for the expression balance checker.
     * @param args the command-line arguments 
     */
    public static void main(String[] args) {
        while (true) {
            try {
                String choice = JOptionPane.showInputDialog(null, 
                    "Choose an option:\n1. Check if expression is balanced\n2. Exit", "Expression Balance Checker",
                    JOptionPane.QUESTION_MESSAGE);
                if (choice == null) {
                    break;
                }
                switch (choice) {
                    case "1" -> checkExpression();
                    case "2" -> System.exit(0);
                    default -> JOptionPane.showMessageDialog(null, "Please choose 1 or 2", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Checks if the input expression is balanced.
     * @throws EmptyExpressionException if the expression is empty
     * @throws InvalidExpressionException if the expression is not balanced
     */
    private static void checkExpression() throws EmptyExpressionException, InvalidExpressionException {
        String expression = JOptionPane.showInputDialog(null, "Enter expression to check:", "Check Expression Balance", JOptionPane.QUESTION_MESSAGE);
        if (expression == null || expression.trim().isEmpty()) {
            throw new EmptyExpressionException("Expression is empty.");
        }
        
        boolean isBalanced = isBalancedExpression(expression.trim());
        if (isBalanced) {
            JOptionPane.showMessageDialog(null, "The expression is balanced.\n" + expression, "Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            throw new InvalidExpressionException("The expression is not balanced.\n" + expression);
        }
    }

    /**
     * Determines if the given expression is balanced.
     * @param expression - the expression to check
     * @return true if the expression is balanced, false if not
     */
    private static boolean isBalancedExpression(String expression) {
        deque.clear(); 
        //check for closing delimiter with no matching opening delimiter
        for (char c : expression.toCharArray()) {
            if (isOpenDelimiter(c)) {
                deque.addToFront(c);
            } else if (isCloseDelimiter(c)) {
                if (deque.isEmpty()) {
                    return false;  
                }
                //Delimiters don't match
                char lastOpen = deque.removeFront();
                if (!isMatchingPair(lastOpen, c)) {
                    return false;   
                }
            }
        }
        //all delimiters match
        return deque.isEmpty(); 
    }

    /**
     * Checks if the character is an opening delimiter.
     * @param c the character to check
     * @return true if the character is an opening delimiter, false if not
     */
    private static boolean isOpenDelimiter(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    /**
     * Checks if the character is a closing delimiter.
     * @param c the character to check
     * @return true if the character is a closing delimiter, false if not
     */
    private static boolean isCloseDelimiter(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    /**
     * Checks if a pair of characters are matching delimiters.
     * @param open the opening delimiter
     * @param close the closing delimiter
     * @return true if the characters are matching delimiters, false if not
     */
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}
