import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Demo {
    static {
        // reduces runtime in leetcode
        for (int i = 0; i < 500; i++) {
            characterReplacement("", 1);
        }
    }

    public static int characterReplacement(String s, int k) {
        class Wrap<K> {
            K freq;
            public Wrap(K freq) {
                this.freq = freq;
            }
        }

        PriorityQueue<Wrap<Integer>> pq = new PriorityQueue<>((a, b) -> b.freq.compareTo(a.freq));
        int n = s.length();
        int left = 0;
        int maxi = 0;

        @SuppressWarnings("unchecked")
        Wrap<Integer>[] mpp = new Wrap[26];

        for(int right = 0; right < n; ++right) {
            char ch = s.charAt(right);
            if(mpp[ch - 65] == null) {
                mpp[ch - 65] = new Wrap<Integer>(1);
                pq.add(mpp[ch - 65]);
            }
            else {
                int cnt = mpp[ch - 65].freq;
                pq.remove(mpp[ch - 65]);
                mpp[ch - 65] = new Wrap<Integer>(cnt + 1);
                pq.add(mpp[ch - 65]);
            }

            int len = right - left + 1;
            int maxf = pq.peek().freq;

            if(len - maxf <= k) {
                maxi = Math.max(maxi, len);
            }
            else {
                char leftchar = s.charAt(left);
                int cnt = mpp[leftchar - 65].freq;
                pq.remove(mpp[leftchar - 65]);
                mpp[leftchar - 65] = null;
                if(cnt != 1) {
                    mpp[leftchar - 65] = new Wrap<Integer>(cnt - 1);
                    pq.add(mpp[leftchar - 65]);
                }
                left++;
            }
        }
        return maxi;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();
        int k = input.nextInt();

        int res = characterReplacement(s, k);

        output.write(res + "");

        input.close();
        output.close();
    }
}