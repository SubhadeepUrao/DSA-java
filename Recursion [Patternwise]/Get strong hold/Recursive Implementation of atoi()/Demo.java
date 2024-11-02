class Solution {
    public static long getNum(String str, int pos, boolean isPos) {
        if(pos < 0) return 0;

        char ch = str.charAt(pos);
        if(Character.isDigit(ch)) {
            long num = getNum(str, pos-1, isPos) * 10 + ch - 48;
            if(isPos && num > 2147483647) return 2147483647;
            if(!isPos && num > 2147483648L) return 2147483648L;
            return num;
        }
        else return 0;
    }
    public static boolean isPositive(String str) {
        char ch = str.charAt(0);
        if(Character.isDigit(ch) || ch == '+') {
            return true;
        }
        return false;
    }
    public static String extract(String str, int pos, int n) {
        if(pos == n) return "";

        char ch = str.charAt(pos);
        if(Character.isDigit(ch))
            return ch + extract(str, pos+1, n);
        return "";
    }
    public int myAtoi(String s) {
        
        s = s.trim();
        if(s.equals("")) return 0;

        char ch = s.charAt(0);
        if(!( Character.isDigit(ch) || ch == '+' || ch == '-')) return 0;
        s = ch + extract(s, 1, s.length());
        int n = s.length();
        boolean isPos = isPositive(s);
        
        long num = getNum(s, n-1, isPos);
        if(isPos) return (int)num;
        return (int)(num * -1);
    }
}