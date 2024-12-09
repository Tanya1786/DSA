package Stack2;

public class InfixEvaluator {
  public static int evaluateInfix(String infix) {
      String postfix = PostfixConverter.convertToPostfix(infix);
      return PostfixEvaluator.evaluatePostfix(postfix);
  }
}
