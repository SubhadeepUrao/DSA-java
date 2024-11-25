import java.util.ArrayList;
import java.util.TreeMap;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}
class Solution
{
    static class Pair {
        Node node;
        int row;
        Pair(Node node, int row) {
            this.node = node;
            this.row = row;
        }
    }
    
    static void dfs(Node root, int row, int col, TreeMap<Integer, Pair> mpp) {
        if(root == null) return;
        
        if(!mpp.containsKey(col) || row >= mpp.get(col).row) {
            mpp.put(col, new Pair(root, row));
        }
        dfs(root.left, row + 1, col - 1, mpp);
        dfs(root.right, row + 1, col + 1, mpp);
    }
    
    public ArrayList<Integer> bottomView(Node root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        TreeMap<Integer, Pair> mpp = new TreeMap<>();
        dfs(root, 0, 0, mpp);
        
        for(Pair pair : mpp.values())
            res.add(pair.node.data);
        
        return res;
    }
}