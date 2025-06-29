class Solution {
  public String longestCommonPrefix(String[] strs) {
    String prefix = strs[0];
    int totalStrs = strs.length;
    for (int i = 1; i < totalStrs; ++i) {
      while (!strs[i].startsWith(prefix)) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) return "";
      }
    }
    return prefix;
  }

  // public String longestCommonPrefix(String[] strs) {
  // char[] ref = strs[0].toCharArray();
  // int last = ref.length;
  // for (String str : strs) {
  // int n = str.length();
  // int i = 0;

  // while (i < n && i < last && str.charAt(i) == ref[i])
  // ++i;

  // if (i == 0)
  // return "";

  // last = Math.min(last, i);
  // }
  // return strs[0].substring(0, last);
  // }
}