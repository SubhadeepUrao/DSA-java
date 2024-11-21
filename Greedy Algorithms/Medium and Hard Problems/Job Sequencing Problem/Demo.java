import java.util.ArrayList;
import java.util.Arrays;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
public class Demo {

    ArrayList<Integer> JobScheduling(Job jobs[], int n) {
        Arrays.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));
        
        boolean[] deadline = new boolean[n];
        int profit = 0;
        int done = 0;
        
        for(int i = 0; i < n; ++i) {
            if(deadline[jobs[i].deadline-1] == false) {
                deadline[jobs[i].deadline-1] = true;
                done++;
                profit += jobs[i].profit;
            }
            else {
                int pos = jobs[i].deadline - 2;
                while(pos >= 0 && deadline[pos] == true) pos--;
                if(pos >= 0) {
                    deadline[pos] = true;
                    done++;
                    profit += jobs[i].profit;
                }
            }
        }
        return new ArrayList<>(Arrays.asList(done, profit));
    }
}