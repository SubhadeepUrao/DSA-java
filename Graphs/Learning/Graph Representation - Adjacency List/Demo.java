import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    void addToAdjacencyList(List<Integer> list, int node) {
        int pos = Collections.binarySearch(list, node);
        if(pos < 0) pos = -(pos + 1);
        list.add(pos, node);
    }
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < V; ++i)
            res.add(new ArrayList<>());
        
        for(int[] edge : edges) {
            addToAdjacencyList(res.get(edge[0]), edge[1]);
            addToAdjacencyList(res.get(edge[1]), edge[0]);
        }
        
        return res;
    }
}