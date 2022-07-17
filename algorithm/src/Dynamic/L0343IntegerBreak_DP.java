package com.hans.Dynamic;

import java.util.Arrays;

/**
 * @author hans
 */
public class L0343IntegerBreak_DP {


    public static int integerBreak(int n) {
        int[] memo = new int [n+1];
        Arrays.fill(memo, -1);

        memo[1] = 1;

        for(int i=2; i<= n; i++){
            // split i
            for(int j=1; j<=i-1; j++){
                // j + (i-j)
                memo[i] = Math.max( memo[i], Math.max(j*(i-j), j *memo[i-j]) );
            }
        }

        return memo[n];
    }

    public static void main(String[] args) {

    }
}
