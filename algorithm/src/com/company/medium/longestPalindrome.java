package com.company.medium;

public class longestPalindrome {

    public static String longestPalindromeDp(String s){
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
                maxLen = 2; // if true mean there are 2 characters
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

    public static String longestPalindrome(String s) {

        int n = s.length();

        int longest = 0, left = 0, right = 0;

        for(int i=0; i < n; i++){
            for( int j=i+1; j<=n; j++){
                String substr = s.substring(i, j);
                if(isPalindrome(substr) && substr.length() > longest){
                    longest = substr.length();
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left, right);
    }

    public static boolean isPalindrome(String s){
        if(s == null || s.isEmpty()) return false;

        int n = s.length();
        for( int i=0; i <n; i++){
            if(s.charAt(i) != s.charAt(n-i-1)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "pxyxpcbabd";

        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeDp(s));
    }
}
