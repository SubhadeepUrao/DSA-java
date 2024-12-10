import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    class Pair {
        String word;
        List<String> path;
        Pair(String word, List<String> path) {
            this.word = word;
            this.path = path;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> visited = new HashSet<>(wordList);
        Set<String> visitedOnLevel = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        int wordSize = beginWord.length();
        boolean found = false;

        q.offer(new Pair(beginWord, Collections.singletonList(beginWord)));
        visitedOnLevel.add(beginWord);

        while(!q.isEmpty()) {
            visited.removeAll(visitedOnLevel);
            visitedOnLevel.clear();

            int qSize = q.size();
            for(int k = 0; k < qSize; ++k) {
                String word = q.peek().word;
                List<String> path = q.poll().path;

                for(int i = 0; i < wordSize; ++i) {
                    char[] replacedString = word.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ++ch) {
                        char temp = replacedString[i];
                        replacedString[i] = ch;
                        String nextWord = new String(replacedString);
                        List<String> updatedPath = new ArrayList<>(path);
                        updatedPath.add(nextWord);
                        
                        if(visited.contains(nextWord)) {
                            if(nextWord.equals(endWord)) {
                                res.add(updatedPath);
                                found = true;
                            }
                            visitedOnLevel.add(nextWord);
                            q.offer(new Pair(nextWord, updatedPath));
                        }
                        replacedString[i] = temp; 
                    }
                }
            }
            if(found) return res;
        }
        return res;
    }
}