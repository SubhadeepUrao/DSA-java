import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Demo {

    public static String frequencySort(String s) {
        class Pair{
            int cnt;
            char ch;
            Pair(int cnt, char ch) {
                this.cnt = cnt;
                this.ch = ch;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((i, j) -> j.cnt - i.cnt);
        HashMap<Character, Integer> mpp = new HashMap<>();

        int n = s.length();
        for(int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry: mpp.entrySet()) {
            pq.add(new Pair(entry.getValue(), entry.getKey()));
        }

        StringBuilder str = new StringBuilder();

        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            for(int i = 0; i < pair.cnt; ++i) {
                str.append(pair.ch);
            }
        }
        return str.toString();
    }
    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();

        String res = frequencySort(s);

        output.write(res);

        input.close();
        output.close();
    }
}