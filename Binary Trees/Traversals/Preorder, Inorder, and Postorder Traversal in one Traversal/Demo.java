import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
public class Demo {
    static class Pair<K, V> {
        K node;
        V num;
        Pair(K node, V num) {
            this.node = node;
            this.num = num;
        }
    }
    static void allTraversalsAtOnce(List<List<Integer>> list, TreeNode root) {
        Stack<Pair<TreeNode, Integer>> st = new Stack<>();

        st.push(new Pair<>(root, 1));
        while(!st.empty()) {
            Pair<TreeNode, Integer> top = st.peek();
            root = top.node;
            int num = top.num;

            if(num == 1) { // preorder
                list.get(1).add(root.data);
                ++top.num;
                if(root.left != null) st.push(new Pair<>(root.left, 1));
            }
            if(num == 2) { // inorder
                list.get(0).add(root.data);
                ++top.num;
                if(root.right != null) st.push(new Pair<>(root.right, 1));
            }
            if(num == 3) { // postorder
                list.get(2).add(root.data);
                st.pop();
            }
        }
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());

        allTraversalsAtOnce(list, root);

        return list;
    }
}