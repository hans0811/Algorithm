package com.company.sliderwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {

    public static int lengthOfLongestSubstringSliding2(String s){
        int ans=0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int left = 0, right =0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)), left);
            }
            ans = Math.max(ans, right-left + 1);
            map.put(s.charAt(right), right+1);
        }
        return ans;
    }

    public int lengthOfLongestSubstringSliding(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans=0, left = 0, right =0;

        while(left < n && right < n){
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                ans = Math.max(ans, right- left);
            }else{
                set.remove(s.charAt(right++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int start = 0; start < s.length(); start++){
            Set<Character> longSubStr = new HashSet<>();

            for(int end=start; end < s.length(); end++){
                if(longSubStr.contains(s.charAt(end))){
                    break;
                }
                longSubStr.add(s.charAt(end));
            }
            maxLength = Math.max(maxLength, longSubStr.size());
        }
        return maxLength;
    }


    public static void main(String[] args) {
        String test = "abcabcbb";

        System.out.println(lengthOfLongestSubstringSliding2(test));

    }
}
