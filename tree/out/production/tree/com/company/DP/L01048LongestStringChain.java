package leetcode.DP;

import java.util.*;

public class L01048LongestStringChain {

    public static Map<Integer, List<String>> wordLenMap;
    public static Map<String, Integer> memo;

    public static int longestStrChain(String[] words) {
        // store each word with its corresponding length
        wordLenMap = new HashMap<>();

        for(String word : words){
            wordLenMap.putIfAbsent(word.length(), new ArrayList<>());
            wordLenMap.get(word.length()).add(word);
        }

        int maxPath = 1;
        memo = new HashMap<>();

        for(String word:words){
            maxPath = Math.max(maxPath, dfs(word));
        }
        return maxPath;
    }

    public static int dfs(String word){
        // if there are no words of the next length
        if(!wordLenMap.containsKey(word.length() + 1)) return 1;
        if(memo.containsKey(word)) return memo.get(word);

        int maxPath = 1;
        // Compare next word (length + 1), see if only different less or equal
        List<String> nextWords = wordLenMap.get(word.length() + 1);
        for(String nextWord : nextWords){
            if(isDifferEqualOne(word, nextWord)){
                maxPath = Math.max(maxPath, dfs(nextWord));
            }
        }

        memo.put(word, maxPath +1);
        return memo.get(word);

    }

    //
    public static boolean isDifferEqualOne(String a, String b){
        int count = 0;

        for(int i=0, j=0; i < a.length() && j < b.length() && count <=1; i++){
            if(a.charAt(i) != b.charAt(j)) count ++;
            else j++;
        }
        return count <= 1;

    }

    public static void main(String[] args) {
        
        String[] str = {"a","b","ba","bca","bda","bdca"};

        System.out.println(longestStrChain(str));
        
    }
}
