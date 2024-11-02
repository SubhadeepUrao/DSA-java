import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Demo {

    // public static int countDistinctSubsequence(HashSet<String> hs, int i, int n, String str, String newStr) {
        
    //     if(hs.contains(newStr)) return 0;
    //     if(i == n) {
    //         hs.add(newStr);
    //         return 1;
    //     }
    //     int count = countDistinctSubsequence(hs, i+1, n, str, newStr + str.charAt(i));
    //     count += countDistinctSubsequence(hs, i+1, n, str, newStr);
    //     return count;
    // }
    // public static String betterString(String str1, String str2) {
    //     int count1 = countDistinctSubsequence(new HashSet<>(), 0, str1.length(), str1, new String());
    //     int count2 = countDistinctSubsequence(new HashSet<>(), 0, str2.length(), str2, new String());
        
    //     return count1 >= count2 ? str1 : str2;
    // }

    public static void distinctSubsequence(HashSet<String> hs, char[] sublist, int i, int j, char[] arr, int n) {
        if(i == n) {
            hs.add(String.valueOf(sublist, 0, j));
            return;
        }
        sublist[j] = arr[i];
        distinctSubsequence(hs, sublist, i+1, j+1, arr, n);
        distinctSubsequence(hs, sublist, i+1, j, arr, n);
    }

    public static String betterString(String str1, String str2) {
        HashSet<String> hs = new HashSet<>();
        
        char[] arr1 = str1.toCharArray();
        distinctSubsequence(hs, new char[arr1.length], 0, 0, arr1, arr1.length);
        int count1 = hs.size();
        // System.out.println(hs);
        hs.clear();
        
        // hs = new HashSet<>();
        char[] arr2 = str2.toCharArray();
        distinctSubsequence(hs, new char[arr2.length], 0, 0, arr2, arr2.length);
        int count2 = hs.size();        
        // System.out.println(hs);

        
        return count1 >= count2 ? str1 : str2;
    }

    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String str1 = input.next();
        String str2 = input.next();

        String res = betterString(str1, str2);

        output.write(res);

        input.close();
        output.close();
        
    }
}
