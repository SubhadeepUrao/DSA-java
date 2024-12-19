import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DisjoinSet {
    List<Integer> size;
    List<Integer> parent;

    DisjoinSet(int N) {
        size = IntStream.generate(() -> 1).limit(N).boxed().collect(Collectors.toList());
        parent = IntStream.range(0, N).boxed().collect(Collectors.toList());
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

        if(size.get(repOfX) < size.get(repOfY))
            parent.set(repOfX, repOfY);
        else if(size.get(repOfX) > size.get(repOfY))
            parent.set(repOfY, repOfX);
        else {
            parent.set(repOfY, repOfX);
            int sizeX = size.get(repOfX);
            int sizeY = size.get(repOfY);
            size.set(repOfX, sizeX + sizeY);
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