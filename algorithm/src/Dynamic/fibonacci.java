package com.hans.Dynamic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author hans
 */
public class fibonacci {

    public static int num = 0;
    //public static ArrayList<Integer> memo = new ArrayList<>();
    public static HashMap<Integer, Integer> dp = new HashMap<>();

    public static int fibFor( int n ){

        dp.put(0, 0);
        dp.put(1,1);
        for(int i=2; i<=n; i++){
            dp.put(i, dp.get(i-1) + dp.get(i-2));
        }

        return dp.get(n);
    }

    public static int fib( int n ){

        num++;
        if( n == 0 ) return 0;

        if( n == 1 ) return  1;

        if( !dp.containsKey(n) ){
            dp.put( n,  fib(n-1) + fib(n-2));
        }

        return dp.get(n);

    }

    public static void main(String[] args) {

        System.out.println(fibFor(7));

    }
}
