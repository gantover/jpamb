package jpamb.cases;

public class Recursions {
    public static int factorial(int n) {
        if (n > 1) {
            return n * factorial(n - 1);
        }
        return 1;
    }
    public static int badFactorial(int n) {
        if (n > 1) {
            return n * badFactorial(n + 1);
        }
        return 1;
    }
}
