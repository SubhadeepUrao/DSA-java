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
    static int mini;
    static int maxi;
    static void traverse(List<List<int[]>> list, TreeNode root, int x, int y) {
        if(root != null) {
            if(x < mini) {
                list.add(0, new ArrayList<>()); // add at front
                mini = x;
            }
            else if(x > maxi) {
                list.add(new ArrayList<>()); // add at rear
                maxi = x;
            }
            
            list.get(x - mini).add(new int[]{ root.val, y });
            traverse(list, root.left, x - 1, y + 1);
            traverse(list, root.right, x + 1, y + 1);
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        mini = maxi = 0;

        List<List<int[]>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        traverse(list, root, 0, 0);
        for(List<int[]> sublist : list) {
            sublist.sort((a, b) -> {
                int cmp = Integer.compare(a[1], b[1]);
                return cmp != 0 ? cmp : Integer.compare(a[0], b[0]);
            });

            List<Integer> mappedList = sublist.stream().map(pair -> pair[0]).toList(); // toList() is part of the Java 16
            // List<Integer> mappedList = sublist.stream().map(pair -> pair[0]).collect(Collectors.toList()); // prior to java 16 use this
            res.add(mappedList);
        }
        return res;
    }
}