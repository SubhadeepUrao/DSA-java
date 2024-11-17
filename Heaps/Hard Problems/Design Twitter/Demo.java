import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class Twitter {
    static HashMap<Integer, HashSet<Integer>> mpp;
    static int timestamp;
    static ArrayList<Pair<Integer, Integer>>[] tweetBook;

    static class Pair<K,V> {
        K timestamp;
        V tweetId;
        Pair(K timestamp, V tweetId) {
            this.timestamp = timestamp;
            this.tweetId = tweetId;
        }
    }

    @SuppressWarnings("unchecked")
    public Twitter() {
        mpp = new HashMap<>();
        timestamp = 0;
        tweetBook = (ArrayList<Pair<Integer, Integer>>[]) new ArrayList[501];
    }
    
    public void postTweet(int userId, int tweetId) {
        if(tweetBook[userId] == null) {
            tweetBook[userId] = new ArrayList<Pair<Integer, Integer>>();
            tweetBook[userId].add(new Pair<>(timestamp, tweetId));
        }
        else {
            tweetBook[userId].add(0, new Pair<>(timestamp, tweetId));
        }
        ++timestamp;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.timestamp.compareTo(a.timestamp)
            );
        
        if(mpp.containsKey(userId)) {
            for(int id : mpp.get(userId)) {
                if(tweetBook[id] != null)
                    pq.addAll(tweetBook[id]);
            }
        }
        if(tweetBook[userId] != null)
            pq.addAll(tweetBook[userId]);

        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(pq.peek() != null) {
            list.add(pq.remove().tweetId);
            ++cnt;
            if(cnt == 10) break;
        }
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!mpp.containsKey(followerId)) {
            mpp.put(followerId, new HashSet<>(Collections.singleton(followeeId)));
        }
        else {
            mpp.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(mpp.containsKey(followerId)) {
            mpp.get(followerId).remove(followeeId);
        }
    }
}