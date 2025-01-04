import java.util.Arrays;

class Solution {
    int minCost(int[] cuts, int i, int j) {
        if (i > j) return 0;

        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j; ++k) {
            int left = minCost(cuts, i, k - 1);
            int right = minCost(cuts, k + 1, j);
            mini = Math.min(mini, left + right);
        }
        return mini + cuts[j + 1] - cuts[i - 1];
    }

    public int minCost(int length, int[] cuts) {
        int N = cuts.length;
        Arrays.sort(cuts);
        int[] temp = new int[N + 2];

        int i = 1;
        for (int cut : cuts) temp[i++] = cut;
        temp[0] = 0;
        temp[N + 1] = length;

        return minCost(temp, 1, N);
    }
}

// class Solution {
//     int minCost(int[] cuts, int i, int j) {
//         int mini = Integer.MAX_VALUE;
//         for(int cut : cuts) {
//             if(i < cut && cut < j) {
//                 int left = minCost(cuts, i, cut);
//                 int right = minCost(cuts, cut, j);
//                 mini = Math.min(mini, left + right);
//             }
//         }
//         return mini != Integer.MAX_VALUE ? mini + j - i : 0;
//     }
//     public int minCost(int length, int[] cuts) {
//         Arrays.sort(cuts);
//         return minCost(cuts, 0, length);
//     }
// }