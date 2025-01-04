import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    int maxCoins(List<Integer> nums) {
        if (nums.size() == 2) return 0;

        int maxi = Integer.MIN_VALUE;
        int N = nums.size() - 1;
        for (int k = 1; k < N; ++k) {
            int cost = nums.get(k - 1) * nums.get(k) * nums.get(k + 1);
            int removed = nums.remove(k);
            maxi = Math.max(maxi, maxCoins(nums) + cost);
            nums.add(k, removed);
        }
        return maxi;
    }

    public int maxCoins(int[] nums) {
        List<Integer> newNums = Arrays.stream(nums).mapToObj(Integer::valueOf).collect(Collectors.toList());
        newNums.add(0, 1);
        newNums.add(1);

        return maxCoins(newNums);
    }
}