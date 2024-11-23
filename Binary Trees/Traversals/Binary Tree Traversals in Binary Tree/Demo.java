import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }
    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    static void inOrder(List<Integer> list, TreeNode root) {
        if(root != null) {
            inOrder(list, root.left);
            list.add(root.data);
            inOrder(list, root.right);
        }
    }
    static void preOrder(List<Integer> list, TreeNode root) {
        if(root != null) {
            list.add(root.data);
            preOrder(list, root.left);
            preOrder(list, root.right);
        }
    }
    static void postOrder(List<Integer> list, TreeNode root) {
        if(root != null) {
            postOrder(list, root.left);
            postOrder(list, root.right);
            list.add(root.data);
        }
    }

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());

        inOrder(list.get(0), root);
        preOrder(list.get(1), root);
        postOrder(list.get(2), root);

        return list;
    }
}