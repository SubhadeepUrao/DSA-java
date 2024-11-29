
// HANDLES DUPLICATE NODE VALUES
// FOLLOWS DFS

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {
    
    void buildString(TreeNode root, StringBuilder str) {
        if(root == null) {
            str.append("# ");
            return;
        }
        str.append(root.val).append(' ');
        buildString(root.left, str);
        buildString(root.right, str);
    } 

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder str = new StringBuilder();
        buildString(root, str);
        return str.toString();
    }

    TreeNode buildTree(Queue<String> q) {
        String value = q.poll();

        if(value.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = buildTree(q);
        root.right = buildTree(q);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;

        String[] values = data.split(" ");

        Queue<String> q = new LinkedList<>(Arrays.asList(values));

        return buildTree(q);
    }
}