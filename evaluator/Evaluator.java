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

  public Evaluator() {
    operandStack = new Stack<Operand>();
    operatorStack = new Stack<Operator>();
  }


  public int eval(String expression) {
    String token;
    int temp;

    this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

    while (this.tokenizer.hasMoreTokens()) {
      i++;
      System.out.println("times through the while loop with more tokens: "+i);
      // filter out spaces
      if (!(token = this.tokenizer.nextToken()).equals(" ")) {
        // check if token is an operand
        if (Operand.check(token)) {
          operandStack.push(new Operand(token));
          System.out.println("Top of Operand Stack: " + operandStack.peek().getValue());
        } else {
          if (!Operator.check(token)) {
            System.out.println("*****invalid token******");
            System.exit(1);
          }

          Operator.sortOperation(token);
          Operator newOperator = operator.Operator.getOperator(token);
          System.out.println("new operator: "+newOperator.toStringOperator());

          if (!operatorStack.isEmpty()){
            if (token.equals("(")){
              operatorStack.push(newOperator);
            } 
            else if(token.equals(")")){
              while(!operatorStack.peek().toStringOperator().equals("(")){
                System.out.println(operatorStack.peek().toStringOperator());
                System.out.println("executing Parenthesis");
                executingOperation();
                System.out.println("operator stack after execution: "+operatorStack.peek().toStringOperator());
                System.out.println("top of the operand stack: "+operandStack.peek().getValue());
                if (operatorStack.peek().toStringOperator().equals("(")){
                  break;
                }
              }
              System.out.println("out of loop and popping )");
              operatorStack.pop();
            }
            else {
              System.out.println("op stack priority: "+operatorStack.peek().priority());
              System.out.println("new op priority: "+newOperator.priority());
              while (operatorStack.peek().priority() >= newOperator.priority() && operatorStack.peek().toStringOperator() != "(") {
                executingOperation();
                System.out.println("in");
                System.out.println(operandStack.peek().getValue());
                if (operatorStack.isEmpty()){
                  break;
                }
              }
              operatorStack.push(newOperator);
              System.out.println(operatorStack.peek().toStringOperator());
            }
          }
          else {
            operatorStack.push(newOperator);
            System.out.println(operatorStack.peek().toStringOperator());
          }
        }
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

    while (!operatorStack.isEmpty()){
      executingOperation();
    }
    temp = operandStack.pop().getValue();
    System.out.println("this is the answer: " + temp);
    return temp;
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