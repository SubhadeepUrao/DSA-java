// Manacher's Algorithm

class Solution {
  public static String preprocess(String s) {
    StringBuilder str = new StringBuilder();
    str.append('#');
    for (char ch : s.toCharArray()) {
      str.append(ch);
      str.append('#');
    }
    return new String(str);
  }

  public String longestPalindrome(String s) {
    char[] str = preprocess(s).toCharArray();

    int n = str.length;
    int[] p = new int[n];

    int center = 0;
    int maxi = 0; // length of max suffix/prefix
    int l = 0;
    int r = 0;

    for (int i = 1; i < n; ++i) {
      int k = 0; // length of suffix

      if (i <= r) {
        int j = l + r - i;
        if (l < j - p[j]) {
          p[i] = p[j];
          continue;
        } else {
          k = r - i + 1;
        }
      }

      while (i - k >= 0 && i + k < n && str[i - k] == str[i + k]) {
        ++k;
      }
      --k;

      p[i] = k;

      if (maxi < k) {
        maxi = k;
        center = i;
      }

      // if (r < i + k) {
      l = i - k;
      r = i + k;
      // }
    }

    // return removeHash(new String(Arrays.copyOfRange(str, center - maxi, center + maxi + 1)));

    int start = (center - maxi) / 2;
    return s.substring(start, start + maxi);
  }
}