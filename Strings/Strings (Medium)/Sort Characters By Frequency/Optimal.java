class Solution {
  public static int findMaxCharacter(int[] freq) {
    int maxCh = 0;
    int maxFreq = 0;
    for (int i = 0; i < 128; ++i) {
      if (maxFreq < freq[i]) {
        maxFreq = freq[i];
        maxCh = i;
      }
    }
    return maxCh;
  }

  public String frequencySort(String s) {
    int[] freq = new int[128];

    for (char ch : s.toCharArray())
      ++freq[ch];

    int n = s.length();
    char[] sorted = new char[n];
    int i = 0;

    while (i < n) {
      int maxCh = findMaxCharacter(freq);
      char ch = (char) maxCh;
      while (freq[maxCh]-- > 0) {
        sorted[i++] = ch;
      }
    }
    return new String(sorted);
  }

  // public String frequencySort(String s) {
  //   int[] freq = new int[128];

  //   for (char ch : s.toCharArray())
  //     ++freq[ch];

  //   int n = s.length();
  //   StringBuilder str = new StringBuilder();
  //   int i = 0;

  //   while (i < n) {
  //     int maxCh = findMaxCharacter(freq);
  //     char ch = (char) maxCh;
  //     while (freq[maxCh]-- > 0) {
  //       str.append(ch);
  //       ++i;
  //     }
  //   }
  //   return str.toString();
  // }
}