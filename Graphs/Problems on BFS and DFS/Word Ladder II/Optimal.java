import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    List<List<String>> res;
    Map<String, Integer> mpp;
    int wordSize;

    void dfs(String word, int level, List<String> path) {
        if(level == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        char[] replacedString = word.toCharArray();
        for(int i = 0; i < wordSize; ++i) {
            for(char ch = 'a'; ch <= 'z'; ++ch) {
                char temp = replacedString[i];
                replacedString[i] = ch;
                String prevWord = new String(replacedString);
                if(mpp.containsKey(prevWord) && mpp.get(prevWord) == level) {
                        path.add(0, prevWord);
                        dfs(prevWord, level - 1, path);
                        path.remove(0);
                }
                replacedString[i] = temp;
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>(wordList);
        boolean found = false;

        wordSize = beginWord.length();
        mpp = new HashMap<>();

        mpp.put(beginWord, 1);
        q.offer(beginWord);
        visited.remove(beginWord);

        while(!q.isEmpty()) {
            String word = q.poll();
            int level = mpp.get(word);

            if(word.equals(endWord)) {
                found = true;
                break;
            }

            char[] replacedString = word.toCharArray();
            for(int i = 0; i < wordSize; ++i) {
                for(char ch = 'a'; ch <= 'z'; ++ch) {
                    char temp = replacedString[i];
                    replacedString[i] = ch;
                    String nextWord = new String(replacedString);
                    if(visited.contains(nextWord)) {
                        visited.remove(nextWord);
                        q.offer(nextWord);
                        mpp.put(nextWord, level + 1);
                    }
                    replacedString[i] = temp;
                }
            }
        }
        res = new ArrayList<>();
        if(!found) return res;

        List<String> path = new LinkedList<>();
        path.add(endWord);
        dfs(endWord, mpp.get(endWord) - 1, path);
        return res;
    }
}