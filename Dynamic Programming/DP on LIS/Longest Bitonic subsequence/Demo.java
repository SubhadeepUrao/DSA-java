class Solution {
    public static int LongestBitonicSequence(int N, int[] nums) {
        int maxi = 0;
        int[] pre = new int[N];
        pre[0] = 1;

        for (int i = 1; i < N - 1; ++i) {
            int lmax = 0;
            for (int prev = 0; prev < i; ++prev) {
                if (nums[prev] < nums[i])
                    lmax = Math.max(lmax, pre[prev]);
            }
            pre[i] = lmax + 1;
        }

        int[] post = new int[N];
        post[N - 1] = 1;

        for (int i = N - 2; i > 0; --i) {
            int rmax = 0;
            for (int next = i + 1; next < N; ++next) {
                if (nums[i] > nums[next])
                    rmax = Math.max(rmax, post[next]);
            }
            post[i] = rmax + 1;

            if (pre[i] > 1 && post[i] > 1)
                maxi = Math.max(maxi, pre[i] + post[i] - 1);
        }
        return maxi;
    }
}
