package com.hans.Dynamic;

import java.util.Arrays;
import java.util.List;

/**
 * @author hans
 */
public class L0070ClimbingStairs {

    public int[] memo;

//    public int calcWays(int n){
//
//        if(n == 0 || n == 1) return 1;
//
//////        if( n == 1 ) return 1;
//////        if( n == 2 ) return 2;
//
//        if(memo[n] == -1){
//            memo[n] = climbStairs(n-1) + climbStairs(n-2);
//        }
//
//        return memo[n];
//    }

    public int climbStairs(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);

        memo[0] = 1;
        memo[1] = 1;

        for(int i=2; i <=n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }



}
