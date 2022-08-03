package amazonLeetcode;

import java.util.HashMap;

public class A009_03LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int res = 0;

        for(int l=0, r=0; r < s.length(); r++){

            if(map.containsKey(s.charAt(r))){
                l = Math.max(map.get(s.charAt(r)), l);
            }

            res = Math.max(res, r-l + 1); // abcabc
            map.put(s.charAt(r), r+1);

        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
    }
}
