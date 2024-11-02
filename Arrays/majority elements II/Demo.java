import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static List< Integer > majorityElementII(int []arr) {
        int cnt1, cnt2 = cnt1 = 0;
        int elem1 = Integer.MIN_VALUE;
        int elem2 = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; ++i) {
            if(cnt1 == 0 && elem2 != arr[i]) {
                cnt1++;
                elem1 = arr[i];
            }
            else if(cnt2 == 0 && elem1 != arr[i]) {
                cnt2++;
                elem2 = arr[i];
            }
            else if(elem1 == arr[i]) cnt1++;
            else if(elem2 == arr[i]) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = cnt2 = 0;
        for(int i = 0; i < arr.length; ++i) {
            if(elem1 == arr[i]) cnt1++;
            if(elem2 == arr[i]) cnt2++;
        }

        List<Integer> list = new ArrayList<>();
        int mini = arr.length / 3 + 1;
        if(cnt1 >= mini) list.add(elem1);
        if(cnt2 >= mini) list.add(elem2);

        // Collections.sort(list);
        list.sort(null);
        return list;
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        List< Integer > list = majorityElementII(arr);
        for(int i = 0; i < list.size(); ++i) 
            output.write(list.get(i) + " ");

        input.close();
        output.close();
        
    }
}
