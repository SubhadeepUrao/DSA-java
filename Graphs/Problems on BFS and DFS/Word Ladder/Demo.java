import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    class Pair {
        String word;
        int pathLength;
        Pair(String word, int pathLength) {
            this.word = word;
            this.pathLength = pathLength;
        }
    }
    boolean canTransform(String source, String target) {
        int n = source.length();
        int diff = 0;
        for(int i = 0; i < n; ++i) {
            if(source.charAt(i) != target.charAt(i)) {
                if(diff == 1) return false;
                ++diff;
            }
        }
        return true;
    }
    
    // public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //     Set<String> set = new HashSet<>(wordList);
    //     Queue<Pair> q = new LinkedList<>();

    //     q.offer(new Pair(beginWord, 1));
    //     while(!q.isEmpty()) {
    //         String word = q.peek().word;
    //         int pathLength = q.poll().pathLength;

    //         if(word.equals(endWord)) return pathLength;

    //         for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
    //             String nextWord = it.next();
    //             if (canTransform(word, nextWord)) {
    //                 q.add(new Pair(nextWord, pathLength + 1));
    //                 it.remove(); // Remove the word from the set to prevent revisiting
    //             }
    //         }

    //     }
    //     return 0;
    // }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        int size = wordList.size();
        boolean[] visited = new boolean[size];

        q.offer(new Pair(beginWord, 1));
        while(!q.isEmpty()) {
            String word = q.peek().word;
            int pathLength = q.poll().pathLength;

            if(word.equals(endWord)) return pathLength;

            for(int i = 0; i < size; ++i) {
                if(!visited[i] && canTransform(word, wordList.get(i))) {
                    q.add(new Pair(wordList.get(i), pathLength + 1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
} 