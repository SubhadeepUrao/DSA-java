import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Demo {
    static void addToAdjacencyList(ArrayList<Integer> list, int node) {
        int pos = Collections.binarySearch(list, node);
        if(pos < 0) pos = -(pos + 1);
        list.add(pos, node);
    }
    static ArrayList<ArrayList<Integer>> getAdjacencyList(int V, int edges[][]) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0; i < V; ++i)
            res.add(new ArrayList<>());
        
        for(int[] edge : edges) {
            addToAdjacencyList(res.get(edge[0]), edge[1]);
            addToAdjacencyList(res.get(edge[1]), edge[0]);
        }
        
        return res;
    }
    static ArrayList<Integer> traverseConnectedComponent(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {
        ArrayList<Integer> component = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        
        while(!q.isEmpty()) {
            int currNode = q.poll();
            ArrayList<Integer> list = adjList.get(currNode);
            if(list.size() == 0) {
                component.add(currNode);
                visited[currNode] = true;
            }
            else {
                for(int node : list) {
                    if(!visited[node]) {
                        q.offer(node);
                        component.add(node);
                        visited[node] = true;
                    }
                }
            }
        }
        component.sort(null);
        return component;
    }
    static ArrayList<ArrayList<Integer>> connectedcomponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = getAdjacencyList(V, edges);
        
        boolean[] visited = new boolean[V];
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < V; ++i) {
            if(!visited[i]) {
                ArrayList<Integer> component = traverseConnectedComponent(i, visited, adjList);
                res.add(component);
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int V = input.nextInt();
        int E = input.nextInt();
        int[][] edges = new int[E][2];
        for(int i = 0; i < E; ++i) {
            edges[i][0] = input.nextInt();
            edges[i][1] = input.nextInt();
        }

        ArrayList<ArrayList<Integer>> res = connectedcomponents(V, edges);

        output.write(res.toString());

        input.close();
        output.close();
    }
}