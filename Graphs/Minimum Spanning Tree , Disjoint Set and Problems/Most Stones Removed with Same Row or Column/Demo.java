import java.util.HashMap;
import java.util.Map;

class Solution {
    class Node {
        int rank;
        Node next;
    }

    Node find(Node node) {
        if(node.next == null) return node;
        return node.next = find(node.next);
    }

    void union(Node X, Node Y) {
        if(X.rank < Y.rank) {
            X.next = find(Y);
        }
        else if(X.rank > Y.rank) {
            Y.next = find(X);
        }
        else {
            Y.next = find(X);
            X.rank++;
        }
    }

    public int removeStones(int[][] stones) {
        Map<Integer, Node> rowMap = new HashMap<>();
        Map<Integer, Node> colMap = new HashMap<>();
        int edges = 0;

        for(int[] stone : stones) {
            int x = stone[0];
            int y = stone[1];
            Node curr = new Node();

            if(rowMap.containsKey(x) && colMap.containsKey(y)) { // both row and column representative exist
                Node repX = find(rowMap.get(x));
                Node repY = find(colMap.get(y));
                if(repX == repY) { // both belong to same cluster
                    union(repX, curr); // attached stone to either of them
                    ++edges; // introduces one edge
                }
                else { // belong to different clusters
                    union(repY, curr); // attached stone to first cluster
                    union(repX, repY); // attached first to second cluster
                    edges += 2; // introduces two edge
                }
            }
            else if(rowMap.containsKey(x)) { // only row representative exist
                Node repX = find(rowMap.get(x));
                colMap.put(y, curr); // column representative
                union(repX, curr);
                ++edges;
            }
            else if(colMap.containsKey(y)) { // only column representative exist
                Node repY = find(colMap.get(y));
                rowMap.put(x, curr); // row representative
                union(repY, curr);
                ++edges;
            }
            else { // cluster representative
                rowMap.put(x, curr); // row representative
                colMap.put(y, curr); // column representative
            }
        }
        return edges;
    }
}