import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Optimal {
    
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int N = hand.length;
        if(N % groupSize > 0) return false;

        for(int i = 0; i < N; ++i) {
            if(hand[i] > -1) {
                int rem = groupSize;
                int j = i;
                int key = hand[i];
                while(rem > 0) {
                    if(j == N) return false;
                    if(hand[j] == key) {
                        hand[j] = -1;
                        --rem;
                        ++key;
                    }
                    ++j;
                }
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