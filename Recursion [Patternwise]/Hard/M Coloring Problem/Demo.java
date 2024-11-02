import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static boolean canBePainted(int currColor, int[] color, List<Integer> nodes) {
        for (int nextNode : nodes) {
            if (color[nextNode] == currColor)
                return false;
        }
        return true;
    }

    public static boolean solve(List<Integer>[] graph, int[] color, int M, int node) {
        if (node == color.length)
            return true;

        for (int currColor = 1; currColor <= M; ++currColor) {
            if (canBePainted(currColor, color, graph[node])) {
                color[node] = currColor;
                if (solve(graph, color, M, node + 1))
                    return true;
                color[node] = 0;
            }
        }
        return false;

    }

    public static boolean graphColoring(List<Integer>[] graph, int V, int M) {
        int[] color = new int[V];
        return solve(graph, color, M, 0);
    }

    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int V = input.nextInt(); // vertices
        int M = input.nextInt(); // max colours

        List<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; ++i)
            graph[i] = new ArrayList<>();

        while (input.hasNext()) {
            int a = input.nextInt();
            int b = input.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean res = graphColoring(graph, V, M);

        output.write(res + "");

        input.close();
        output.close();

    }
}
