class Solution {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        boolean evenLevel = false;
        q.offer(root);
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i = 0; i < n; ++i) {
                root = q.poll();
                if(root.left != null) q.offer(root.left);
                if(root.right != null) q.offer(root.right);

                if(evenLevel)
                    sublist.add(0, root.val);
                else
                    sublist.add(root.val);
            }
            evenLevel = !evenLevel;
            list.add(sublist);
        }

        return list;
    }

    // static void solve(List<List<Integer>> list, TreeNode root, int level) {
    //     if(root != null) {
    //         if(level > list.size())
    //             list.add(new ArrayList<>());
    //         if(level % 2 == 0)
    //             list.get(level - 1).add(0, root.val);
    //         else
    //             list.get(level - 1).add(root.val);
    //         solve(list, root.left, level + 1);
    //         solve(list, root.right, level + 1);
    //     }
    // }
    // public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    //     List<List<Integer>> list = new ArrayList<>();
    //     if(root == null) return list;

    //     solve(list, root, 1);
    //     return list;
    // }
}