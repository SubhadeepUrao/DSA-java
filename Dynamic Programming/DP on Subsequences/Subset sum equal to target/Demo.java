class Solution {
    static boolean isSubsetSum(int[] arr, int i, int target) {
        if(target == 0) return true;
        if(i == 0) return arr[0] == target;

        boolean take = target >= arr[i] ? isSubsetSum(arr, i - 1, target - arr[i]) : false;
        boolean notTake = isSubsetSum(arr, i - 1, target);

        return take || notTake;
    }
    static Boolean isSubsetSum(int arr[], int target) {
        return isSubsetSum(arr, arr.length-1, target);
    }
    // static boolean isSubsetSum(int[] arr, int target, int i) {
    //     if(i == arr.length || target < 0) return false;
    //     if(target == arr[i]) return true;
        
    //     return isSubsetSum(arr, target-arr[i], i+1) || isSubsetSum(arr, target, i+1);
    // }
    // static Boolean isSubsetSum(int arr[], int target) {
    //     return isSubsetSum(arr, target, 0);
    // }
}