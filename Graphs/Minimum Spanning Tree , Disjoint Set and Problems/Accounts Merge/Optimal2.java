import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class DisjointSet {
    int[] rank;
    int[] parent;
    DisjointSet(int N) {
        rank = new int[N];
        parent = new int[N];
        for(int i = 0; i < N; ++i)
            parent[i] = i;
    }

    int find(int i) {
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int x, int y) {
        int repX = find(x);
        int repY = find(y);

        if(repX == repY) return;

        if(rank[repX] < rank[repY])
            parent[repX] = repY;
        else if(rank[repX] > rank[repY])
            parent[repY] = repX;
        else {
            parent[repY] = repX;
            ++rank[repX];
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mpp = new HashMap<>();

        for(int accountNo = 0; accountNo < n; ++accountNo) {
            List<String> account = accounts.get(accountNo);

            for(int i = 1; i < account.size(); ++i) {
                String email = account.get(i);
                if(mpp.containsKey(email))
                    ds.union(mpp.get(email), accountNo);
                else
                    mpp.put(email, accountNo);
            }
        }

        List<List<String>> res = new ArrayList<>();
        int[] mappingFunc = new int[n];
        int component = 0;
        for(int i = 0; i < n; ++i)
            if(ds.find(i) == i) {
                res.add(new ArrayList<>(List.of(accounts.get(i).get(0))));
                mappingFunc[i] = component++;
            }
        
        for(String key : mpp.keySet())
            res.get(mappingFunc[ds.find(mpp.get(key))]).add(key);

        for(List<String> group : res)
            Collections.sort(group.subList(1, group.size()));

        return res;
    }
}