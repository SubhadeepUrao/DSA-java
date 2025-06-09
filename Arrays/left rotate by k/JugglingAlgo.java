public class JugglingAlgo {
  public static void rotate(int[] arr, int k) {
    int n = arr.length;
    if (n == 0 || k == 0)
      return;

    k = k % n;
    int cycles = gcd(n, k);

    for (int i = 0; i < cycles; i++) {
      int current = i;
      int prev = arr[i];
      do {
        int next = (current + k) % n;
        int temp = arr[next];
        arr[next] = prev;
        prev = temp;
        current = next;
      } while (current != i);
    }
  }

  private static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
