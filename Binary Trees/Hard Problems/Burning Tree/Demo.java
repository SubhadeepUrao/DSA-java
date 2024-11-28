class Solution
{
    class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }

    int maxPath(Node root) {
        if(root == null) return -1;
        
        return Math.max(maxPath(root.left), maxPath(root.right)) + 1;
    }
    
    int[] findNode(Node root, int target, int[] maxi) {
        if(root == null) return new int[]{ 0, 0 };
        
        if(root.data == target) {
            maxi[0] = maxPath(root);
            return new int[]{ 1, 1 };
        }
        
        int[] left = findNode(root.left, target, maxi);
        if(left[0] > 0) {
            int temp = maxPath(root.right) + 1; // when root.right is null, temp results 0
            maxi[0] = Math.max(maxi[0], left[1] + temp);
            left[1]++;
            return left;
        }
        
        int[] right = findNode(root.right, target, maxi);
        if(right[0] > 0) {
            int temp = left[1];
            maxi[0] = Math.max(maxi[0], temp + right[1]);
            right[1]++;
            return right;
        }
        
        return new int[]{ 0, Math.max(left[1], right[1]) + 1 };
    }
    
    public int minTime(Node root, int target) {
        int[] maxi = new int[1];
        findNode(root, target, maxi);
        return maxi[0];
    }
}