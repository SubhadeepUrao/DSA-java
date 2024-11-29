import java.util.Arrays;
import java.util.Stack;

// HANDLES UNIQUE NODE VALUES

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {
    class Pair<K, V> {
        K node;
        V num;
        Pair(K node, V num) {
            this.node = node;
            this.num = num;
        }
    }
    String findPreorderAndInorder(TreeNode root) {
        if(root == null) return "|";

        StringBuilder preorder = new StringBuilder();
        StringBuilder inorder = new StringBuilder();

        Stack<Pair<TreeNode, Integer>> st = new Stack<>();
        st.push(new Pair<>(root, 1));

        while(!st.empty()) {
            Pair<TreeNode,Integer> top = st.peek();
            root = top.node;

            if(top.num == 1) {
                preorder.append(root.val);
                preorder.append(',');
                ++top.num;
                if(root.left != null) st.push(new Pair<>(root.left, 1));
            }
            else if(top.num == 2) {
                inorder.append(root.val);
                inorder.append(',');
                ++top.num;
                if(root.right != null) st.push(new Pair<>(root.right, 1));
            }
            else
                st.pop();
        }
        preorder.setLength(preorder.length() - 1);
        inorder.setLength(inorder.length() - 1);
        return preorder + "|" + inorder;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return findPreorderAndInorder(root);
    }

    int i, p;
    TreeNode buildTree(int[] preorder, int[] inorder, int stop) {
        if(p == preorder.length) return null;

        if(inorder[i] == stop) {
            ++i;
            return null;
        }

        TreeNode root = new TreeNode(preorder[p++]);
        root.left = buildTree(preorder, inorder, root.val);
        root.right = buildTree(preorder, inorder, stop);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("|")) return null;
        
        String[] traversal = data.split("\\|");

        int[] preorder = Arrays.stream(traversal[0].split(","))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        int[] inorder = Arrays.stream(traversal[1].split(","))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        
        return buildTree(preorder, inorder, Integer.MAX_VALUE);  
    }
}