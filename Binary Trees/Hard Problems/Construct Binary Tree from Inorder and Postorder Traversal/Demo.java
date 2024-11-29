import java.util.HashMap;

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

    HashMap<Integer, Integer> mpp;
    int currPos;
    TreeNode solve(int[] postorder, int start, int end) {
        if(start == end) return null;
        
        int currData = postorder[currPos--];
        TreeNode curr = new TreeNode(currData);

        int index = mpp.get(currData);
        curr.right = solve(postorder, index + 1, end);
        curr.left = solve(postorder, start, index);

        return curr;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        mpp = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i)
            mpp.put(inorder[i], i);
        
        currPos = postorder.length-1;
        return solve(postorder, 0, inorder.length);
    }
}