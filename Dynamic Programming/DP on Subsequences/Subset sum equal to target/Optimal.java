class Solution {
    static Boolean isSubsetSum(int arr[], int target) {
        int N = arr.length;
        boolean[] prev = new boolean[target + 1];

        prev[0] = true;

        if(target >= arr[0])
            prev[arr[0]] = true;

        boolean[] curr = new boolean[target + 1];
        for(int i = 1; i < N; ++i) {
            curr[0] = true;
            for(int j = 1; j <= target; ++j) {
                boolean take = j >= arr[i] ? prev[j - arr[i]] : false;
                boolean notTake = prev[j];
                curr[j] = take || notTake;
                // prev[j]: Represents whether it is possible to achieve a sum of j using the first i+1
                // elements of the array.
            }
            boolean[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[target];
    }
}