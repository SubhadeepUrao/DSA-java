
// HANDLES DUPLICATE NODE VALUES
// FOLLOWS LEVEL ORDER

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();

        q.add(root);
        while(!q.isEmpty()) {
            root = q.poll();
            if(root == null) {
                str.append("# ");
                continue;
            }

            str.append(root.val).append(' ');
            q.add(root.left);
            q.add(root.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;

        String[] values = data.split(" ");

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        int n = values.length;
        for(int i = 1; i < n; ++i) {
            TreeNode parent = q.poll();

            if(!values[i].equals("#")) {
                parent.left = new TreeNode(Integer.parseInt(values[i]));
                q.add(parent.left);
            }
            if(values[++i].equals("#")) {
                parent.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(parent.right);
            }
        }
        return root;
    }
}