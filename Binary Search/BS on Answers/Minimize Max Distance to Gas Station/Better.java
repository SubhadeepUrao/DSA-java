import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Better {
    private static class Pair {
        double first;
        int second;

        public Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static double minimiseMaxDistance(int[] gasStations, int k) {
        Queue<Pair> pq = new PriorityQueue<>((i, j) -> {
            if(i.first > j.first) return -1;
            else if(i.first < j.first) return 1;
            else {
                if(i.second > j.second) return -1;
                else return 1;
            }
        });

        int n = gasStations.length;

        for(int i = 0; i < n-1; ++i) {
            int diff = gasStations[i+1] - gasStations[i];
            pq.add(new Pair(diff, i));
        }

        int[] sector = new int[n-1];

        while(k != 0) {
            Pair pair = pq.poll();
            int index = pair.second;

            sector[index]++;
            double sectionLength = (gasStations[index+1] - gasStations[index]) / (double)(sector[index] + 1);
            pq.add(new Pair(sectionLength, index));
            
            --k;
        }

        return pq.peek().first;
    }

    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int k = input.nextInt();

        int[] gasStations = new int[n];
        for(int i = 0; i < n; ++i)
            gasStations[i] = input.nextInt();

        double res = minimiseMaxDistance(gasStations, k);

        output.write(Double.toString(res));

        input.close();
        output.close();
        
    }
}
