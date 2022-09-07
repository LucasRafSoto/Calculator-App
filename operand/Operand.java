package operand;

public class Operand {

  private int i;

  public Operand(String token) {
    i = convertToInt(token);
  }

  public Operand(int value) {
    this.i = value;
  }

  public int convertToInt(String tokenConnector) {
    int temp = Integer.parseInt(tokenConnector);
    return temp;
  }

  public int getValue() {
    return this.i;
  }

  public static boolean check(String token) {
    if (!token.isEmpty()) {
      try {
        int i = Integer.parseInt(token);
        return true;
      } catch (NumberFormatException err) {
        return false;
      }
    }
    return false;
  }
}
