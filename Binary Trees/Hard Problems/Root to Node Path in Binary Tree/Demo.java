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
    static boolean findPath(TreeNode root, StringBuilder str, int target) {
        if(root == null) return false;

        int n = str.length();
        str.append(root.val);

        if(root.val == target) return true;

        str.append("->");
        if(findPath(root.left, str, target) || findPath(root.right, str, target)) return true;

        str.setLength(n);
        return false;
    }

    public String binaryTreePaths(TreeNode root, int target) {
        if(root == null) return "";
        
        StringBuilder str = new StringBuilder();
        findPath(root, str, target);
        
        return str.toString();
    }
}