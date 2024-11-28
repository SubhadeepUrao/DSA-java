import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    void findNodeAtDistK(List<Integer> res, TreeNode root, int k) {
        if(root == null || k < 0) return;
        if(k == 0) {
            res.add(root.val);
            return;
        }

        findNodeAtDistK(res, root.left, k - 1);
        findNodeAtDistK(res, root.right, k - 1);
    }

    int findNode(List<Integer> res, TreeNode root, TreeNode target, int k) {
        if(root == null) return 0;

        if(root.val == target.val) {
            findNodeAtDistK(res, root, k);
            return 1;
        }

        int left = findNode(res, root.left, target, k);
        if(left > 0) {
            if(left == k) res.add(root.val);
            else findNodeAtDistK(res, root.right, k - left - 1);           
            return left + 1;
        }

        int right = findNode(res, root.right, target, k);
        if(right > 0) {
            if(right == k) res.add(root.val);
            else findNodeAtDistK(res, root.left, k - right - 1);
            return right + 1;
        }

        return 0;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        findNode(res, root, target, k);

        return res;
    }
}