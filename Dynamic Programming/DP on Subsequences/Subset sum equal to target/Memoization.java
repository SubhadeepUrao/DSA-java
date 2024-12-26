import java.util.Arrays;

class Solution {
    static boolean isSubsetSum(int[] arr, int i, int target, int[][] dp) {
        if(target == 0) return true;
        if(i == 0) return arr[0] == target;

        if(dp[i][target] != -1) return dp[i][target] == 1 ? true : false;

        boolean take = target >= arr[i] ? isSubsetSum(arr, i - 1, target - arr[i], dp) : false;
        boolean notTake = isSubsetSum(arr, i - 1, target, dp);

        dp[i][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }
    static Boolean isSubsetSum(int arr[], int target) {
        int N = arr.length;
        int[][] dp = new int[N][target + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return isSubsetSum(arr, N-1, target, dp);
    }
}