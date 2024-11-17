import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Demo {
    
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int N = hand.length;
        if(N % groupSize > 0) return false;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i < N; ++i) {
            pq.add(hand[i]);
            mpp.put(hand[i], mpp.getOrDefault(hand[i], 0) + 1);
        }

        for(int i = 0; i < N; i += groupSize) {
            int root = pq.peek();
            for(int key = root; key < root + groupSize; ++key) {
                if(mpp.containsKey(key)) {
                    pq.remove(key);
                    mpp.put(key, mpp.get(key) - 1);}
                else
                    return false;
                
                if(mpp.get(key) == 0)
                    mpp.remove(key);
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int K = input.nextInt();

        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        boolean res = isNStraightHand(nums, K);
        
        output.write(Boolean.toString(res));
        
        input.close();
        output.close();
    }
}