import java.util.List;

class Solution {
    int minimumTotal(List<List<Integer>> triangle, int i, int j) {
        if(i+1 == triangle.size()) return triangle.get(i).get(j);

        return Math.min(minimumTotal(triangle, i + 1, j),
                minimumTotal(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle, 0, 0);
    }
}