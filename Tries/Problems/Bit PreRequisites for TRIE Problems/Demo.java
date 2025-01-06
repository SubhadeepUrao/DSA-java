class Solution {

    public int XOR(int n, int m) {
        return (n | m) & (~n | ~m);
    }

    public int check(int a, int b) {
        // return ((1 << a - 1) & b) == 0 ? 0 : 1;
        return ((b >> a - 1) & 1) == 0 ? 0 : 1;
    }

    public int setBit(int c, int d) {
        // return ((1 << c) & d) == 0 ? d | (1 << c) : d;
        return ((d >> c) & 1) == 0 ? d | (1 << c) : d;
    }
}