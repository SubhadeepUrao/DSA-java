import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    static void levelOrder(List<List<Integer>> list, TreeNode root, int level) {
        if(root != null) {
            if(level > list.size()) {
                list.add(new ArrayList<>());
            }

            if(level % 2 == 1)
                list.get(level - 1).add(root.val);
            else
                list.get(level - 1).add(0, root.val);
            
            levelOrder(list, root.left, level + 1);
            levelOrder(list, root.right, level + 1);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(list, root, 1);
        return list;
    }
}