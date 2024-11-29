import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    TreeNode solve(List<Integer> preorderList, int start, int end, HashMap<Integer, Integer> mpp) {
        
        if(start == end) return null;

        int currData = preorderList.remove(0);
        TreeNode curr = new TreeNode(currData);

        int index = mpp.get(currData);
        curr.left = solve(preorderList, start, index, mpp);
        curr.right = solve(preorderList, index + 1, end, mpp);
        return curr;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i)
            mpp.put(inorder[i], i);

        List<Integer> preorderList = IntStream.of(preorder).boxed().collect(Collectors.toCollection(ArrayList::new)); 
        // because of primitive array
        // otherwise for Integer array, new ArrayList<>(Arrays.toList(preorder)) would have sufficed
        // List<Integer> preorderList = IntStream.of(preorder).boxed().toList();

        TreeNode root = solve(preorderList, 0, inorder.length, mpp);
        return root;
    }
}