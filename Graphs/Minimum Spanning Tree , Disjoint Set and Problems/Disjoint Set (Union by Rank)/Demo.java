import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DisjoinSet {
    List<Integer> rank;
    List<Integer> parent;

    DisjoinSet(int N) {
        rank = IntStream.generate(() -> 0).limit(N).boxed().collect(Collectors.toList()); // returns mutable list
        // rank = IntStream.generate(() -> 0).limit(N).boxed().toList(); // returns immutable list

        parent = IntStream.range(0, N).boxed().collect(Collectors.toList()); // returns mutable list
        // parent = IntStream.range(0, N).mapToObj(Integer::valueOf).toList(); // returns immutable list
        // parent = IntStream.range(0, N).boxed().toList(); // also returns immutable list
    }

    // time complexity : O(4*alpha)
    int find(int i) { // also path compresses
        if(parent.get(i) == i) return i;
        
        parent.set(i, find(parent.get(i)));

        return parent.get(i);
    }

    // time complexity : O(4*alpha)
    void union(int X, int Y) {
        int repOfX = find(X); // representative of set X
        int repOfY = find(Y); // representative of set Y

        if(repOfX == repOfY) return; // part of the same set

        if(rank.get(repOfX) < rank.get(repOfY))
            parent.set(repOfX, repOfY);
        else if(rank.get(repOfX) > rank.get(repOfY))
            parent.set(repOfY, repOfX);
        else {
            parent.set(repOfX, repOfY);
            int rank = this.rank.get(repOfY);
            this.rank.set(repOfY, rank + 1);
        }
    }
}
public class Demo {
    public static void main(String[] args) {
        DisjoinSet ds = new DisjoinSet(7); // 7 elements (0 to 6)
        ds.union(1, 2);
        ds.union(3, 6);
        ds.union(4, 5);
        ds.union(3, 1);
        ds.union(4, 1);

        System.out.println("Rep of 1 : " + ds.find(1));
        System.out.println("Rep of 4 : " + ds.find(4));
        System.out.println("Rep of 5 : " + ds.find(5));
        System.out.println("Rep of 6 : " + ds.find(6));
    }
}