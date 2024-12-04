class Node { 
    int data; 
    Node left, right; 
   
    public Node(int d) { 
        data = d; 
        left = right = null; 
    } 
}


class Solution{
    static class Info {
        int min;
        int max;
        int maxSize;
        Info(int min, int max, int maxSize) {
            this.min = min;
            this.max = max;
            this.maxSize = maxSize;
        }
    }
    static Info solve(Node root) {
        if(root == null) return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        
        Info left = solve(root.left);
        Info right = solve(root.right);
        
        if(left.max < root.data && root.data < right.min) {
            left.min = Math.min(root.data, left.min);
            left.max = Math.max(root.data, right.max);
            left.maxSize += right.maxSize + 1;
            return left;
        }
        left.min = Integer.MIN_VALUE;
        left.max = Integer.MAX_VALUE;
        left.maxSize = Math.max(left.maxSize, right.maxSize);
        return left;
    }
    static int largestBst(Node root) {
        return solve(root).maxSize;
    }
}