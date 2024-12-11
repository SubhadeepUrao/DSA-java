import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    class Pair {
        int i, j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    boolean[][] visited;
    Set<Set<Integer>> islands;

    void infect(int[][] grid, int i, int j, Pair base, Set<Integer> island) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || visited[i][j] || grid[i][j] == 0) return;

        visited[i][j] = true;
        island.add((i - base.i) + (j - base.j) * grid.length); // column-major
        // island.add((i - base.i) * grid[0].length + (j - base.j)); // row-major

        infect(grid, i, j - 1, base, island); // left
        infect(grid, i - 1, j, base, island); // up
        infect(grid, i, j + 1, base, island); // right
        infect(grid, i + 1, j, base, island); // down
    }
    int countDistinctIslands(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        islands = new HashSet<>();

        for(int i = 0; i < grid.length; ++i)
            for(int j = 0; j < grid[0].length; ++j)
                if(!visited[i][j] && grid[i][j] == 1) {
                    Set<Integer> island = new TreeSet<>();
                    infect(grid, i, j, new Pair(i, j), island);
                    islands.add(island);
                }
        
        return islands.size();
    }
}
