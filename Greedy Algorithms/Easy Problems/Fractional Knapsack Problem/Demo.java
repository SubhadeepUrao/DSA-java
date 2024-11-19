import java.util.Arrays;
import java.util.List;

class Knapsack {
    public double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        int n = val.size();
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; ++i)
            pair[i] = new int[] { val.get(i), wt.get(i) };

        Arrays.sort(pair, (a, b) -> Double.compare((double) b[0] / b[1], (double) a[0] / a[1]));
        double total = 0;
        int j = 0;

        while (j < n && capacity - pair[j][1] > 0) {
            total += pair[j][0];
            capacity -= pair[j][1];
            ++j;
        }
        if (j < n && capacity > 0) {
            total += capacity * (double) pair[j][0] / pair[j][1];
        }

        return total;
    }
}