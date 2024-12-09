package Stack2;

public class PostfixEvaluator {
  public static int evaluatePostfix(String postfix) {
      StackInterface<Integer> valueStack = new ArrayStack<>();
      
      for (int i = 0; i < postfix.length(); i++) {
          char nextCharacter = postfix.charAt(i);
          
          if (Character.isWhitespace(nextCharacter)) {
              continue;
          }
          
          if (Character.isDigit(nextCharacter)) {
              valueStack.push(Character.getNumericValue(nextCharacter));
          } else {
              int operandTwo = valueStack.pop();
              int operandOne = valueStack.pop();
              int result = evaluateOperation(nextCharacter, operandOne, operandTwo);
              valueStack.push(result);
          }
      }
      
      return valueStack.peek();
  }
  
  private static int evaluateOperation(char operation, int operandOne, int operandTwo) {
      switch (operation) {
          case '+':
              return operandOne + operandTwo;
          case '-':
              return operandOne - operandTwo;
          case '*':
              return operandOne * operandTwo;
          case '/':
              if (operandTwo == 0) {
                  throw new ArithmeticException("Cannot divide by zero");
              }
              return operandOne / operandTwo;
          case '^':
              return (int) Math.pow(operandOne, operandTwo);
          default:
              throw new UnsupportedOperationException("Unsupported operation: " + operation);
      }
  }
}
