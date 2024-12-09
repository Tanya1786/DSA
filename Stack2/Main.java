package Stack2;

public class Main {
  public static void main(String[] args) {
      String infix = "(3 + 4) * 2";
      
      try {
          int result = InfixEvaluator.evaluateInfix(infix);
          System.out.println("The result of the expression \"" + infix + "\" is: " + result);
      } catch (Exception e) {
          System.err.println("Error: " + e.getMessage());
      }
  }
}
