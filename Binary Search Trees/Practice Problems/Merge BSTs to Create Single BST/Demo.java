import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public TreeNode canMerge(List<TreeNode> trees) {
        // Step 1: Create mappings for root values to trees and leaves
        Map<Integer, TreeNode> rootMap = new HashMap<>();
        Set<Integer> leaves = new HashSet<>();

        for (TreeNode tree : trees) {
            rootMap.put(tree.val, tree);
            if (tree.left != null) leaves.add(tree.left.val);
            if (tree.right != null) leaves.add(tree.right.val);
        }

        // Step 2: Identify the main root
        TreeNode root = null;
        for (TreeNode tree : trees) {
            if (!leaves.contains(tree.val)) {
                if (root != null) return null; // Multiple roots found
                root = tree;
            }
        }

        if (root == null) return null; // No valid root found

        // Step 3: Merge trees
        mergeTrees(root, rootMap);

        // Step 4: Validate BST and check unused trees
        return rootMap.size() == 1 && isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? root : null;
    }

    void mergeTrees(TreeNode node, Map<Integer, TreeNode> rootMap) {
        if (node == null) return;

        if (node.left != null && rootMap.containsKey(node.left.val)) {
            node.left = rootMap.remove(node.left.val);
            mergeTrees(node.left, rootMap);
        }

        if (node.right != null && rootMap.containsKey(node.right.val)) {
            node.right = rootMap.remove(node.right.val);
            mergeTrees(node.right, rootMap);
        }
    }

    boolean isValidBST(TreeNode node, int low, int high) {
        if (node == null) return true;
        if (node.val <= low || node.val >= high) return false;
        return isValidBST(node.left, low, node.val) && isValidBST(node.right, node.val, high);
    }
}