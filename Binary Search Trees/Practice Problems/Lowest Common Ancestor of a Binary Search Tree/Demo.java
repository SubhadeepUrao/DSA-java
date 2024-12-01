class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

   
class Solution {
    // TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {
    //     if(p.val < root.val && root.val < q.val)
    //         return root;
        
    //     if(root.val == p.val || root.val == q.val)
    //         return root;
        
    //     return q.val < root.val ? solve(root.left, p ,q) : solve(root.right, p , q);
    // }
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { 
    //     if(p.val < q.val)
    //         return solve(root, p, q);
    //     return solve(root, q, p);
    // }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { 
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p , q);
        
        return root;
    }
}