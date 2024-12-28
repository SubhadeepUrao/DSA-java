import java.util.Arrays;

class Solution {
    int findContentChildren(int[] greed, int[] size, int i, int j) {
        if(i < 0 || j < 0) return 0;

        if(greed[i] <= size[j]) {
            int includeCookie = findContentChildren(greed, size, i-1, j-1) + 1;
            int excludeCookie = findContentChildren(greed, size, i, j-1);
            return Math.max(includeCookie, excludeCookie);
        }
        return findContentChildren(greed, size, i-1, j);
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // Sort greed factors
        Arrays.sort(s); // Sort cookie sizes
        int N = g.length;
        int M = s.length;

        return findContentChildren(g, s, N-1, M-1);
    }
}
