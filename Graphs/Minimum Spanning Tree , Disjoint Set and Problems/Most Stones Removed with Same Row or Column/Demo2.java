import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    class Node {
        int rank;
        Node parent;

        Node() {
            this.rank = 0;
            this.parent = this;
        }
    }

    private Node find(Node node) {
        if (node != node.parent) {
            node.parent = find(node.parent); // Path compression
        }
        return node.parent;
    }

    private void union(Node x, Node y) {
        Node rootX = find(x);
        Node rootY = find(y);

        if (rootX != rootY) {
            if (rootX.rank < rootY.rank) {
                rootX.parent = rootY;
            } else if (rootX.rank > rootY.rank) {
                rootY.parent = rootX;
            } else {
                rootY.parent = rootX;
                rootX.rank++;
            }
        }
    }

    public int removeStones(int[][] stones) {
        Map<Integer, Node> rowMap = new HashMap<>();
        Map<Integer, Node> colMap = new HashMap<>();

        for (int[] stone : stones) {
            int x = stone[0];
            int y = stone[1];

            // Create or get the representative for the row and column
            rowMap.putIfAbsent(x, new Node());
            colMap.putIfAbsent(y, new Node());

            // Union the row and column representatives
            union(rowMap.get(x), colMap.get(y));
        }

        // Count unique connected components
        Set<Node> uniqueComponents = new HashSet<>();
        for (int[] stone : stones) {
            int x = stone[0];
            uniqueComponents.add(find(rowMap.get(x)));
        }

        // Calculate the number of removable stones
        return stones.length - uniqueComponents.size();
    }
}
