import java.util.HashMap;

class Solution {
    int curr;
    HashMap<Integer, Integer> mpp;
    TreeNode solve(int[] preorder, int start, int end) {
        if(start == end) return null;

        int currData = preorder[curr++];
        TreeNode curr = new TreeNode(currData);

        int index = mpp.get(currData);
        curr.left = solve(preorder, start, index);
        curr.right = solve(preorder, index + 1, end);
        return curr;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mpp = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i) {
            mpp.put(inorder[i], i);
        }
        
        return solve(preorder, 0, inorder.length);
    }
}