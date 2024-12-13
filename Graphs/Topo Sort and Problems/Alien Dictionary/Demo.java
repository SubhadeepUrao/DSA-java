import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Demo {
    static List<List<Integer>> graphify(String[] dict, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; ++i)
            adj.add(new ArrayList<>());

        for (int i = 1; i < dict.length; ++i) {
            String first = dict[i - 1];
            String second = dict[i];
            int minLen = Math.min(first.length(), second.length());
            int pos = 0;
            while (pos < minLen && first.charAt(pos) == second.charAt(pos)) {
                pos++;
            }
            if(pos < minLen)
                adj.get(second.charAt(pos) - 'a').add(first.charAt(pos) - 'a');
        }
        return adj;
    }

    static boolean[] visited;
    static boolean[] visitedPath;
    static char[] res;
    static int next;

    static boolean detectCycleDFS(List<List<Integer>> adj, int node) {
        visited[node] = true;
        visitedPath[node] = true;

        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour] && detectCycleDFS(adj, neighbour))
                return true;
            else if (visitedPath[neighbour])
                return true;
        }
        visitedPath[node] = false;
        res[next++] = (char) (node + 'a');
        return false;
    }

    public static String findOrder(String[] dict, int k) {
        List<List<Integer>> adj = graphify(dict, k);
        visited = new boolean[k];
        visitedPath = new boolean[k];
        res = new char[k];
        next = 0;

        for (int node = 0; node < k; ++node) {
            if (!visited[node] && detectCycleDFS(adj, node))
                return "";
        }

        return String.join(" < ", new String(res).split(""));
        // return IntStream.range(0, res.length)
        //                 .mapToObj(i -> String.valueOf(res[i]))
        //                 .collect(Collectors.joining(" < "));
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        String[] dict = new String[N];
        for (int i = 0; i < N; ++i) {
            dict[i] = input.next();
        }
        int k = input.nextInt();

        String res = findOrder(dict, k);

        output.write(res);

        input.close();
        output.close();
    }
}