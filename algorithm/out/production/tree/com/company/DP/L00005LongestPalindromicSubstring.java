package leetcode.DP;

import common.utils;

import java.util.HashSet;
import java.util.Set;

public class L00005LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        //int maxBegin=0, maxLen = 1;

        boolean table[][] = new boolean[n][n];

        // All substrings of length 1 are palindroms
        int maxLen = 1;
        for(int i=0; i<n; ++i){
            table[i][i] = true;
        }

        // check for sub-string of length 2
        int start = 0;
        for(int i=0; i < n-1; ++i){
            if(s.charAt(i) == s.charAt(i + 1)) {
                table[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // check for lengths greater than 2
        // k is length of substring
        for( int k=3; k <= n; ++k) {

            // fix the starting index
            for (int i=0; i < n-k +1; ++i){
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if(table[i + 1][j - 1]
                        && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;

                    if( k > maxLen) {
                        start = i;
                        maxLen = k;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }

    public static boolean isPalindrome(String s){
        if(s == null || s.isEmpty()) return false;

        int n = s.length();
        for( int i=0; i <n; i++){
            if(s.charAt(i) != s.charAt(n-i-1)) return false;
        }
        return true;
    }

    // for loop
    public static String longestPalindrome01(String s){
        if(s.length() < 2) return s;
        int sLen = s.length(), maxLen=0, start=0;
        for(int i=0; i < sLen-1; i++){
            searchPalindorme(s, i, i, start, maxLen);
            searchPalindorme(s, i, i+1, start, maxLen);
        }

        return s.substring(start, maxLen);
    }

    public static void searchPalindorme(String s, int l, int r, int start, int maxLen){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        if(maxLen < r - l -1){
            start = l + 1;
            maxLen = r - l -1;
        }

    }

    public void findAllPalindromesBruteForce(String str){
        Set<String> set = new HashSet<>();
        for( int i=0; i < str.length(); i++){
            for( int j=i+1; j <= str.length(); j++){
                String temp = str.substring(i, j);
                if(isPalindrome(temp)){
                    set.add(temp);
                }
            }
        }
    }


    public static String longestPalindromeDP(String s){
        if(s.length() < 2) return s;
        int sLen = s.length(), maxLen=1, left=0;

        int[][] dp = new int[sLen][sLen];

        for(int k=0; k < sLen; k++){
            dp[k][k] = 1;
        }

        for(int i=0; i < sLen; i++){

            for(int j = 0; j < i; j++){

                if(s.charAt(i) == s.charAt(j) && (i-j < 2 || dp[j+1][i-1] == 1)){
                    dp[j][i] = 1;
                }

                System.out.println("j " + j + " i " + i);
                utils.print(dp);

                if(dp[j][i] == 1 && maxLen < i - j +1){
                    maxLen = i -j + 1;
                    left = j;
                }
            }
        }

        return s.substring(left, maxLen);
    }


    public static void main(String[] args) {

        String str = "babad";

        System.out.println(longestPalindromeDP(str));
    }

}
