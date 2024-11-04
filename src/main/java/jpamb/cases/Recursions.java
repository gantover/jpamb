package jpamb.cases;

import jpamb.utils.Case;

public class Recursions {

  @Case("(100000) -> depth exceeded")
  @Case("(5) -> ok")
  public static int factorial(int n) {
    if (n > 1) {
      return n * factorial(n - 1);
    }
    return 1;
  }

  @Case("(5) -> depth exceeded")
  @Case("(1) -> ok")
  public static int badFactorial(int n) {
    if (n > 1) {
      return n * badFactorial(n + 1);
    }
    return 1;
  }

  @Case("() -> depth exceeded")
  public static void alwaysRecursive() {
    alwaysRecursive();
  }

  @Case("(1) -> *")
  public static int neverFactorial(int n) {
    int i = 1;
    while (i > 0) {
    }

    if (n > 1) {
      return n * neverFactorial(n - 1);
    }
    return 1;
  }
}
