package com.hans.Dynamic;

import java.text.BreakIterator;
import java.util.Arrays;

/**
 * @author hans
 */
public class L0343IntegerBreak {

    public static int[] memo;

    // break n at least 2 parts.
    public static int BreakIterator(int n){
        if( n == 1){
            return 1;
        }

        if(memo[n] != -1){
            return memo[n];
        }

        int res = Integer.MIN_VALUE;
        for(int i=1; i <= n-1; i++ ){
            // i + (n-i)
            res = Math.max(res,  Math.max( i*(n-i), i * BreakIterator(n-i) ));
        }
        memo[n] = res;
        return res;
    }

    public static int integerBreak(int n) {
        memo = new int [n+1];
        Arrays.fill(memo, -1);
        return BreakIterator(n);
    }

    public static void main(String[] args) {

    }
}
