import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if(root == null) return res;
        
        ArrayList<Integer> list = new ArrayList<>();   
        Stack<TreeNode> st = new Stack<>();

        while(root != null || !st.empty()) {
            while(root != null) {
                list.add(root.val);
                st.push(root);
                root = root.left;
            }
            
            if(st.peek().right != null)
                root = st.peek().right;
            else {
                if(st.peek().left == st.peek().right) { // leaf node
                    // res.add(String.join("->", list.stream().map(String::valueOf).toList()));
                    res.add(list.stream().map(String::valueOf).collect(Collectors.joining("->")));
                }
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