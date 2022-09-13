package evaluator;

import operand.Operand;

import operator.Operator;

import java.util.*;

public class Evaluator {
  private int i = 0;
  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;

  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/() ";

  public void executingOperation() {
    Operator oldOpr = operatorStack.pop();
    Operand op2 = operandStack.pop();
    Operand op1 = operandStack.pop();
    operandStack.push(oldOpr.execute(op1, op2));
  }

  public void scanningForOps(String token) {
    if (Operand.check(token)) {
      operandStack.push(new Operand(token));
    } else {
      Operator newOperator = evaluatingNewOperator(token);

      utilizingNewOperator(newOperator);
    }
  }

  public Operator evaluatingNewOperator(String token) {
    if (!Operator.check(token)) {
      System.out.println("*****invalid token******");
      System.exit(1);
    }

    Operator.sortOperation(token);
    Operator newOperator = operator.Operator.getOperator(token);
    return newOperator;
  }

  public void utilizingNewOperator(Operator operate) {
    if (!operatorStack.isEmpty()) {
      parentheticalEvaluation(operate);
    } else {
      operatorStack.push(operate);
    }
  }

  public void parentheticalExecution() {
    while (!operatorStack.peek().toStringOperator().equals("(")) {
      executingOperation();
      if (operatorStack.peek().toStringOperator().equals("(")) {
        break;
      }
    }
  }

  public void parentheticalEvaluation(Operator operate) {
    if ((operate.toStringOperator()).equals("(")) {
      operatorStack.push(operate);
    } else if ((operate.toStringOperator()).equals(")")) {
      parentheticalExecution();
      operatorStack.pop();
    } else {
      while (operatorStack.peek().priority() >= operate.priority()
          && operatorStack.peek().toStringOperator() != "(") {
        executingOperation();
        if (operatorStack.isEmpty()) {
          break;
        }
      }
      operatorStack.push(operate);
    }
  }

  public int solution() {
    int temp;

    while (!operatorStack.isEmpty()) {
      executingOperation();
    }
    temp = operandStack.pop().getValue();
    return temp;
  }

  public Evaluator() {
    operandStack = new Stack<Operand>();
    operatorStack = new Stack<Operator>();
  }

  public int eval(String expression) {
    String token;

    this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

    while (this.tokenizer.hasMoreTokens()) {
      if ((token = this.tokenizer.nextToken()).equals(" ")) {
        continue;
      } else {
        scanningForOps(token);
      }
    }

    // Control gets here when we've picked up all of the tokens; you must add
    // code to complete the evaluation - consider how the code given here
    // will evaluate the expression 1+2*3
    // When we have no more tokens to scan, the operand stack will contain 1 2
    // and the operator stack will have + * with 2 and * on the top;
    // In order to complete the evaluation we must empty the stacks (except
    // the init operator on the operator stack); that is, we should keep
    // evaluating the operator stack until empty
    // Suggestion: create a method that takes an operator as argument and
    // then executes the while loop; also, move the stacks out of the main
    // method

    return solution();
  }

  /**
   * Class to help test your Evaluator:
   * javac EvaluatorTester
   * java EvaluatorTester "1+2" "3*5"
   */
  public static void main(String[] args) {
    Evaluator evaluator = new Evaluator();

    for (String arg : args) {
      System.out.format("%s = %d\n", arg, evaluator.eval(arg));
    }
  }
}