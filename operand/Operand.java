package operand;

public class Operand {

  private int i;

  public Operand(String token) {
    System.out.println("Were in");
    setI(token);
    System.out.println(i);
  }

  public Operand(int value) {
    this.i = value;
  }

  public void setI(String tokenConnector) {
    int temp = Integer.parseInt(tokenConnector);
    System.out.println(temp);
    this.i = temp;
  }

  public int getValue() {
    System.out.println(i);
    return this.i;
  }

  public static boolean check(String token) {
    if (!token.isEmpty()) {
      try {
        int i = Integer.parseInt(token);
        return true;
      } catch (NumberFormatException err) {
        System.out.println(err);
        return false;
      }
    }
    return false;
  }
}
