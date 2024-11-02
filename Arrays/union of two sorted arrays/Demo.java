import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static List<Integer> sortedArrayUnion(int []a, int []b) {
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;
        int k = -1;
        List<Integer> list = new ArrayList<>();

        while(i < n && j < m) {
            if(a[i] < b[j]) {
                if(list.isEmpty() || list.get(k) != a[i]) {
                    list.add(a[i]);
                    k++;
                }
                i++;
            }
            else if(a[i] > b[j]) {
                if(list.isEmpty() || list.get(k) != b[j]) {
                    list.add(b[j]);
                    k++;
                }
                j++;
            }
            else {
                if(list.isEmpty() || list.get(k) != a[i]) {
                    list.add(a[i]);
                    k++;
                }
                i++;
                j++;
            }
        }
        while(i < n) {
            if(list.get(k) != a[i]) {
                list.add(a[i]);
                k++;
            }
            i++;
        }
        while(j < m) {
            if(list.get(k) != b[j]) {
                list.add(b[j]);
                k++;
            }
            j++;
        }
        return list;
    }

    public static void print(List<Integer> list, FileWriter output) throws IOException {
        int size = list.size();
        for(int i = 0; i < size; ++i) {
            output.write(list.get(i) + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int m = input.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];
        for(int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        for(int i = 0; i < m; i++) {
            b[i] = input.nextInt();
        }

        List<Integer> list = sortedArrayUnion(a, b);

        print(list, output);

        input.close();
        output.close();
        
    }
}
