class Solution {
  public String reverseWords(String s) {
    char[] ch = s.toCharArray();
    StringBuilder revStr = new StringBuilder();
    StringBuilder word = new StringBuilder();
    int n = ch.length;
    for (int i = n - 1; i >= 0; --i) {
      if (ch[i] != ' ') {
        word.append(ch[i]);
      } else {
        if (word.length() > 0) {
          word.reverse();
          word.append(' ');
          revStr.append(word);
          word.setLength(0);
        }
      }
    }
    if (word.length() > 0) {
      word.reverse();
      revStr.append(word);
    }
    return revStr.toString().trim();
  }
}