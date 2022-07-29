package algorithm.string;

import java.util.*;

public class l00890FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> ans = new ArrayList<>();
        for(String word : words){
            Boolean valid = true;
            HashMap<Character, Character> s2p = new HashMap<>();
            HashMap<Character, Character> p2s = new HashMap<>();
            for(int i=0; i < word.length(); i++){

                Character c = word.charAt(i);
                if(s2p.containsKey(c) && s2p.get(c) != pattern.charAt(i)) valid = false;
                if(p2s.containsKey(pattern.charAt(i)) && p2s.get(pattern.charAt(i)) == c) valid = false;
                s2p.put(c, pattern.charAt(i));
                p2s.put(pattern.charAt(i), c);

            }

            if(valid){
                ans.add(word);
            }



        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
