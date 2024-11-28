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
    // negative backtracking is cleverly used here
    static int result;
    public int solve(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }

        int LH = solve(root.left, start);
        int RH = solve(root.right, start);

        if (root.val == start) {
            result = Math.max(LH, RH);
            return -1;
        } else if (LH >= 0 && RH >= 0) {
            return Math.max(LH, RH) + 1;
        } else {
            int d = Math.abs(LH) + Math.abs(RH);
            result = Math.max(result, d);

            return Math.min(LH, RH) - 1;
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        result = 0;
        solve(root, start);
        return result;
    }
}