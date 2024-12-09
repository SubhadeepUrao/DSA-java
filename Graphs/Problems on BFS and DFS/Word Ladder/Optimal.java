import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();

        int wordSize = beginWord.length();
        for (String word : wordList) {
            for (int i = 0; i < wordSize; ++i) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                graph.putIfAbsent(key, new ArrayList<>());
                graph.get(key).add(word);
            }
        }

        q.offer(new Pair(beginWord, 1));
        while (!q.isEmpty()) {
            String word = q.peek().word;
            int pathLength = q.poll().pathLength;

            for (int i = 0; i < wordSize; ++i) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                if (graph.containsKey(key)) {
                    for (String nextWord : graph.get(key)) {
                        if (nextWord.equals(endWord)) return pathLength + 1;
                        if (!visited.contains(nextWord)) {
                            visited.add(nextWord);
                            q.offer(new Pair(nextWord, pathLength + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

}