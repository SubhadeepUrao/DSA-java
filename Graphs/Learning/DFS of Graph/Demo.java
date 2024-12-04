import java.util.ArrayList;
import java.util.Stack;

class Solution {
    
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[adj.size()];
        
        st.push(0);
        while(!st.empty()) {
            int currNode = st.pop();
            if(!visited[currNode]) {
                dfs.add(currNode);
                visited[currNode] = true;
                ArrayList<Integer> explorable = adj.get(currNode);
                for(int i = explorable.size()-1; i >= 0; --i) {
                    int node = explorable.get(i);
                    if(!visited[node])
                        st.push(node);
                }
            }
        }
        return dfs;
    }
}