class Solution {
  public boolean isIsomorphic(String s, String t) {
    char[] a = s.toCharArray();
    char[] b = t.toCharArray();

    if (a.length != b.length) return false;

    int n = a.length;
    int[] mapA = new int[256];
    int[] mapB = new int[256];
    
    for (int i = 0; i < n; ++i) {
      if (mapA[a[i]] == mapB[b[i]]) {
        mapA[a[i]] = mapB[b[i]] = i + 1;
      } 
      else return false;
    }
    return true;
  }
}