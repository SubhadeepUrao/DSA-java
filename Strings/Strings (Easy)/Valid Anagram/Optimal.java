class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    int[] freq = new int[256];
    int n = s.length();
    char[] a = s.toCharArray();
    char[] b = t.toCharArray();

    for (int i = 0; i < n; ++i) {
      ++freq[a[i]];
      --freq[b[i]];
    }
    for (int cnt : freq) {
      if (cnt != 0) return false;
    }
    return true;
  }
}