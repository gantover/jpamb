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

  @Case("(5, -1) -> depth exceeded")
  @Case("(0, 0) -> ok")
  public static int product(int x, int y) { 
    if (x < y) {
        return product(y, x); 
    } else if (y != 0) {
        return x + product(x, y - 1); 
    }
    return 0;
  }

  @Case("(2147483647) -> ok")
  public static int sumDigits(int n) {
    if (n == 0) {
      return 0;
    }
    return (n % 10 + sumDigits(n / 10));
  }

  @Case("([I: 2, 3, 4, 5, 6, 8, 9, 10, 25, 30, 50, 100], 2, 0, 11) -> ok")
  @Case("([I: ], 1, 1 , 1) -> out of bounds")
  public static int binarySearch(int[] arr, int target, int low, int high) {
    if (low > high) {
      return -1;
    }
    int mid = low + (high - low) / 2;
    if (arr[mid] == target) return mid;
    if (arr[mid] > target) return binarySearch(arr, target, low, mid - 1);
    return binarySearch(arr, target, mid + 1, high);
  }

  @Case("([I: 2, 1, 3], 0, 2) -> ok")
  @Case("([I: ], 0, 0) -> out of bounds")
  public static void mergeSort(int arr[], int l, int r) {
    if (l < r) {
      int m = l + (r - l) / 2;

      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);

      // Merge:
      int n1 = m - l + 1;
      int n2 = r - m;
  
      int L[] = new int[n1];
      int R[] = new int[n2];
  
      for (int i = 0; i < n1; ++i) {
        L[i] = arr[l + i];
      }
      for (int j = 0; j < n2; ++j) {
        R[j] = arr[m + 1 + j];
      }
  
      int i = 0;
      int j = 0;
      int k = l;
      while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
          arr[k] = L[i];
          i++;
        } else {
          arr[k] = R[j];
          j++;
        }
        k++;
      }
  
      while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
      }
  
      while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
      }
    }
  }

  @Case("(100) -> ok")
  @Case("(2147483647) -> depth exceeded")
  @Case("(99) -> assertion error")
  public static int confusingRecursion(int n) {
    if (n > 100) {
      n = confusingRecursion(n - 100);
    }

    if (n < 99) {
      n = confusingRecursion(n + 99);
    }
    assert n == 100;
    return n;
  }

  @Case("(0, 0) -> ok")
  public static int gcd(int n1, int n2) {
    if (n2 != 0) {
      return gcd(n2, n1 % n2);
    }  
    return n1;
  }

  @Case("(100000) -> depth exceeded")
  @Case("(0) -> ok")
  public static int fib(int i) {
    if (i == 0 || i == 1)
      return i;
    return fib(i - 1) + fib(i - 2);
  }
}
