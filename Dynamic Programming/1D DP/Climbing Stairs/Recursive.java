class Solution {
    int climbStairs(int i) {
        if(i == 0) return 1;
        if(i < 0) return 0;
        
        return climbStairs(i-1) + climbStairs(i-2);
    }
}