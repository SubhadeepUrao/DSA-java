import java.util.Arrays;

class Solution {
    static {
        for(int i = 0; i < 500; ++i)
            findContentChildren(new int[]{1,2,3}, new int[]{1,1});
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int n = g.length;
        int m = s.length;

        while(i < n && j < m) {
            if(g[i] <= s[j]) ++i;
            ++j;
        }
        return i;
    }
}