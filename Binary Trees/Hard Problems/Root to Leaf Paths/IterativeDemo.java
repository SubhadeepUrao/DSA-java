import java.util.ArrayList;
import java.util.Stack;

class Solution {

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        ArrayList<Integer> list = new ArrayList<>();   
        Stack<Node> st = new Stack<>();

        while(root != null || !st.empty()) {
            while(root != null) {
                list.add(root.data);
                st.push(root);
                root = root.left;
            }
            
            if(st.peek().right != null)
                root = st.peek().right;
            else {
                if(st.peek().left == st.peek().right) // leaf node
                    res.add(new ArrayList<>(list));
                do {
                    root = st.pop();
                    list.remove(list.size() - 1);
                } while(!st.empty() && st.peek().right == root);
                
                root = null;
            }
        }
        
        return res;
    }
}