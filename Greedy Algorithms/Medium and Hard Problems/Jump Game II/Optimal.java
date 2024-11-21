public class Optimal {
    public static int jump(int[] nums) {
        // O(N) solution
        int goal = nums.length - 1;
        int jumps = 0;
        int l = 0;
        int r = 0;

        while(r < goal) {
            int maxi = 0;
            for(int i = l; i <= r; ++i) {
                maxi = Math.max(maxi, i + nums[i]);
            }
            l = r + 1;
            r = maxi;
            ++jumps;
        }

        return jumps;
    }
}
