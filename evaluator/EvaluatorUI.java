package evaluator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class EvaluatorUI extends JFrame implements ActionListener {
  private static TextField txField = new TextField();
  private Panel buttonPanel = new Panel();

  private static final String[] bText = {
      "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
      "*", "0", "^", "=", "/", "(", ")", "C", "CE"
  };
  private Button[] buttons = new Button[bText.length];

  private static String expression = " ";

  private static boolean isInvalid = false;

  private static int evaluate() {
    try {
      Evaluator evaluator = new Evaluator();
      return evaluator.eval(expression);
    } catch (Exception e) {
      isInvalid = true;
      clearExpression();
      return 0;
    }
  }

  private static void clearExpression() {
    expression = " ";
    eventEvaluations.clear();
  }

  private static String removeLastCharacter(String fullExpression) {
    return fullExpression.substring(0, fullExpression.length() - 1);
  }

  private static int solution;

  private static void maintainValidity() {
    while (isInvalid) {
      txField.setText("Invalid Expression");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      isInvalid = false;
    }
  }

  private static void performActions(int eventArray) {
    if (eventArray >= 0 && eventArray <= 19) {
      sortEvents(eventArray);
      maintainValidity();
    }
    if (!eventEvaluations.isEmpty()) {
      expression += eventEvaluations.get(eventArray);
      eventEvaluations.remove(eventArray);
      txField.setText(expression);
    } else if (eventEvaluations.isEmpty()) {
      txField.setText(expression);
    }
    if (eventArray == 14) {
      String stringsolution = Integer.toString(solution);
      txField.setText(stringsolution);
    }
  }

  private static HashMap<Integer, String> eventEvaluations = new HashMap<Integer, String>();

  public static void sortEvents(int eventLocation) {
    switch (eventLocation) {
      case 0: {
        eventEvaluations.put(eventLocation, "7");
        break;
      }
      case 1: {
        eventEvaluations.put(eventLocation, "8");
        break;
      }
      case 2: {
        eventEvaluations.put(eventLocation, "9");
        break;
      }
      case 3: {
        eventEvaluations.put(eventLocation, "+");
        break;
      }
      case 4: {
        eventEvaluations.put(eventLocation, "4");
        break;
      }
      case 5: {
        eventEvaluations.put(eventLocation, "5");
        break;
      }
      case 6: {
        eventEvaluations.put(eventLocation, "6");
        break;
      }
      case 7: {
        eventEvaluations.put(eventLocation, "-");
        break;
      }
      case 8: {
        eventEvaluations.put(eventLocation, "1");
        break;
      }
      case 9: {
        eventEvaluations.put(eventLocation, "2");
        break;
      }
      case 10: {
        eventEvaluations.put(eventLocation, "3");
        break;
      }
      case 11: {
        eventEvaluations.put(eventLocation, "*");
        break;
      }
      case 12: {
        eventEvaluations.put(eventLocation, "0");
        break;
      }
      case 13: {
        eventEvaluations.put(eventLocation, "^");
        break;
      }
      case 14: {
        solution = evaluate();
        clearExpression();
        break;
      }
      case 15: {
        eventEvaluations.put(eventLocation, "/");
        break;
      }
      case 16: {
        eventEvaluations.put(eventLocation, "(");
        break;
      }
      case 17: {
        eventEvaluations.put(eventLocation, ")");
        break;
      }
      case 18: {
        expression = removeLastCharacter(expression);
        break;
      }
      case 19: {
        clearExpression();
        break;
      }
      default: {
        break;
      }
    }
  }

  public static void main(String[] args) {
    EvaluatorUI calc = new EvaluatorUI();
  }

  public EvaluatorUI() {
    setLayout(new BorderLayout());

    add(txField, BorderLayout.PAGE_START);
    txField.setEditable(false);

    add(buttonPanel, BorderLayout.CENTER);
    buttonPanel.setLayout(new GridLayout(5, 4));

    for (int i = 0; i < bText.length; i++) {
      buttons[i] = new Button(bText[i]);
      buttonPanel.add(buttons[i]);
      buttons[i].addActionListener(this);
    }

    setTitle("Calculator");
    setSize(400, 400);
    setLocationByPlatform(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    int eventArray = -1;
    for (int i = 0; i < buttons.length; i++) {
      if (event.getSource() == buttons[i]) {
        eventArray = i;
        break;
      }
    }
    performActions(eventArray);
  }
}
