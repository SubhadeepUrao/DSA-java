import java.util.ArrayList;

class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    static void dfs(Node root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
        if(root.left == root.right) {
            list.add(root.data);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.data);
        if(root.left != null) dfs(root.left, res, list);
        if(root.right != null) dfs(root.right, res, list);
        list.remove(list.size() - 1);
    }
    
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, res, list);
        
        return res;
    }
}