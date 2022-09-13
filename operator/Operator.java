package operator;

import java.util.HashMap;

import operand.Operand;

public abstract class Operator {

  private static HashMap<String, Operator> operators = new HashMap<String, Operator>();

  public abstract int priority();

  public abstract String toStringOperator();

  public abstract Operand execute(Operand op1, Operand op2);

  public static void sortOperation(String token) {
    if (check(token)) {
      switch (token) {
        case "-": {
          operators.put(token, new SubstractionOperator());
          break;
        }
        case "+": {
          operators.put(token, new AdditionOperator());
          break;
        }
        case "*": {
          operators.put(token, new MultiplicationOperator());
          break;
        }
        case "/": {
          operators.put(token, new DivisionOperator());
          break;
        }
        case "^": {
          operators.put(token, new ExponentialOperator());
          break;
        }
        case "(": {
          operators.put(token, new OpeningParenthetialOperator());
          break;
        }
        case ")": {
          operators.put(token, new ClosingParentheticalOperator());
          break;
        }
        default: {
          break;
        }
      }
    }
  }

  public static boolean check(String token) {

    if (!token.isEmpty() && !Operand.check(token)) {
      try {
        if (token.indexOf("+-*/^") != 1) {
          return true;
        } else {
          return false;
        }
      } catch (NumberFormatException err) {
        return false;
      }
    } else {
      return false;
    }
  }

  public static Operator getOperator(String token) {
    Operator temp = operators.get(token);
    operators.remove(token);
    return temp;
  }

}

class AdditionOperator extends Operator {
  private int priority;
  private String stringify = "+";

  public AdditionOperator() {
    priority = 2;
  }

  public int priority() {
    return priority;
  }

  public String toStringOperator() {
    return stringify;
  }

  public Operand execute(Operand op1, Operand op2) {
    int temp = op1.getValue() + op2.getValue();
    String stringTemp = String.valueOf(temp);
    Operand temperaryOperand = new Operand(stringTemp);
    return temperaryOperand;
  }
}

class SubstractionOperator extends Operator {
  private int priority;
  private String stringify = "-";

  public SubstractionOperator() {
    priority = 2;
  }

  public int priority() {
    return priority;
  }

  public String toStringOperator() {
    return stringify;
  }

  public Operand execute(Operand op1, Operand op2) {
    int temp = op1.getValue() - op2.getValue();
    String stringTemp = String.valueOf(temp);
    Operand temperaryOperand = new Operand(stringTemp);
    return temperaryOperand;
  }
}

class MultiplicationOperator extends Operator {
  private int priority;
  private String stringify = "*";

  public MultiplicationOperator() {
    priority = 3;
  }

  public int priority() {
    return priority;
  }

  public String toStringOperator() {
    return stringify;
  }

  public Operand execute(Operand op1, Operand op2) {
    int temp = op1.getValue() * op2.getValue();
    String stringTemp = String.valueOf(temp);
    Operand temperaryOperand = new Operand(stringTemp);
    return temperaryOperand;
  }
}

class DivisionOperator extends Operator {
  private int priority;
  private String stringify = "/";

  public DivisionOperator() {
    priority = 3;
  }

  public int priority() {
    return priority;
  }

  public String toStringOperator() {
    return stringify;
  }

  public Operand execute(Operand op1, Operand op2) {
    int temp = op1.getValue() / op2.getValue();
    String stringTemp = String.valueOf(temp);
    Operand temperaryOperand = new Operand(stringTemp);
    return temperaryOperand;
  }
}

class ExponentialOperator extends Operator {
  private int priority;
  private String stringify = "^";

  public ExponentialOperator() {
    priority = 4;
  }

  public int priority() {
    return priority;
  }

  public String toStringOperator() {
    return stringify;
  }

  public Operand execute(Operand op1, Operand op2) {
    int base = op1.getValue();
    int power = op2.getValue();
    int temp = 1;
    for (int i = 1; i <= power; i++) {
      temp *= base;
    }
    String stringTemp = String.valueOf(temp);
    Operand temperaryOperand = new Operand(stringTemp);
    return temperaryOperand;
  }
}

class OpeningParenthetialOperator extends Operator {
  private int priority;
  private String stringify = "(";

  public OpeningParenthetialOperator() {
    priority = 1;
  }

  public int priority() {
    return priority;
  }

  public String toStringOperator() {
    return stringify;
  }

  public Operand execute(Operand op1, Operand op2) {
    return op1;
  }
}

class ClosingParentheticalOperator extends Operator {
  private int priority;
  private String stringify = ")";

  public ClosingParentheticalOperator() {
    priority = 1;
  }

  public int priority() {
    return priority;
  }

  public String toStringOperator() {
    return stringify;
  }

  public Operand execute(Operand op1, Operand op2) {
    return op1;
  }
}