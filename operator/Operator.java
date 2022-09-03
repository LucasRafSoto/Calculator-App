package operator;

import java.util.HashMap;

import javax.naming.spi.DirStateFactory.Result;

import operand.Operand;

public abstract class Operator {
  // The Operator class should contain an instance of a HashMap
  // This map will use keys as the tokens we're interested in,
  // and values will be instances of the Operators.

  // Example:
  // Where does this declaration go? What should its access level be?
  // Class or instance variable? Is this the right declaration?
  // HashMap operators = new HashMap();
  // operators.put( "+", new AdditionOperator() );
  // operators.put( "-", new SubtractionOperator() );

  private static HashMap<String, Operator> operators = new HashMap<String, Operator>();

  public abstract int priority();

  public abstract Operand execute(Operand op1, Operand op2);

  public static void sortOperation(String token) {
    System.out.println("Good");
    if (check(token)) {
      switch (token) {
        case "+": {
          operators.put(token, new AdditionOperator());
          System.out.println("Addition in map");
        }
        case "-": {
          operators.put(token, new SubstractionOperator());
          System.out.println("Sub in map");
        }
        case "/": {
          operators.put(token, new DivisionOperator());
        }
        case "*": {
          operators.put(token, new MultiplicationOperator());
        }
      }
    }
  }

  public static boolean check(String token) {

    if (!token.isEmpty() && !Operand.check(token)) {
      if (token.indexOf("+-*/^") != 1) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  // public static HashMap getCase(String token) {
  // return Case;
  // }
}

class AdditionOperator extends Operator {
  public int priority() {
    return 2;
  }

  public Operand execute(Operand op1, Operand op2) {
    return execute(op1, op2);
  }
}

class SubstractionOperator extends Operator {
  public int priority() {
    return 2;
  }

  public Operand execute(Operand op1, Operand op2) {
    return execute(op2, op1);
  }
}

class MultiplicationOperator extends Operator {
  public int priority() {
    return 3;
  }

  public Operand execute(Operand op1, Operand op2) {
    return execute(op1, op2);
  }
}

class DivisionOperator extends Operator {
  public int priority() {
    return 3;
  }

  public Operand execute(Operand op1, Operand op2) {
    return execute(op1, op2);
  }
}
