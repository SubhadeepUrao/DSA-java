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

    int leftLevel(TreeNode root) {
        if(root == null) return 1;
        return 1 + leftLevel(root.left);
    }
    
    int rightLevel(TreeNode root) {
        if(root == null) return 1;
        return 1 + rightLevel(root.right);
    }

    public int countNodes(TreeNode root) {
        // takes less than O(N) time complexity
        if(root == null) return 0;

        int left = leftLevel(root.left);
        int right = rightLevel(root.right);

        if(left == right)
            return (1 << left) - 1; // 2^lastLevel - 1 ==> #nodes in perfect binary tree
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    // public int countNodes(TreeNode root) {
    //     // takes O(N) time complextiy
    //     if(root == null) return 0;

    //     int left = countNodes(root.left);
    //     int right = countNodes(root.right);

    //     return left + right + 1;
    // }
}