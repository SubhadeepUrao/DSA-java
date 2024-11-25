import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int data) { this.data = data; }
    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
public class Demo {

    static class Pair {
        TreeNode node;
        int row;
        Pair(TreeNode node, int row) {
            this.node = node;
            this.row = row;
        }
    }

    static void dfs(TreeNode root, int row, int col, TreeMap<Integer, Pair> mpp) {
        if(root == null) return;

        // If the column is not in the map or the current node is closer to the root (smaller row)
        if(!mpp.containsKey(col) || row < mpp.get(col).row) {
            mpp.put(col, new Pair(root, row));
        }

        // Recur for left and right subtrees
        dfs(root.left, row + 1, col - 1, mpp);
        dfs(root.right, row + 1, col + 1, mpp);
    }

    public List<Integer> topView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        // Map to store the topmost node for each column
        TreeMap<Integer, Pair> mpp = new TreeMap<>();

        dfs(root, 0, 0, mpp);

        // Collect results from the TreeMap
        // for (Map.Entry<Integer, Pair> entry : mpp.entrySet()) {
        //     res.add(entry.getValue().node.data);
        // }
        for(Pair pair : mpp.values()) {
            res.add(pair.node.data);
        }
        return res;
    }
}