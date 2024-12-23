class Solution {

    static long bottomUp(int n) {
        if(n <= 1) return n;
        
        long prevLast = 0;
        long prevFirst = 1;
        for (int i = 2; i <= n; ++i) {
            long temp = prevFirst;
            prevFirst = (prevFirst + prevLast) % 1000_000_007;
            prevLast = temp;

        }
        return prevFirst;
    }
}