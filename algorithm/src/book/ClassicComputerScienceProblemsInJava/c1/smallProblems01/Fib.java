package com.hans.book.ClassicComputerScienceProblemsInJava.c1.smallProblems01;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Fib {

    //static Map<Integer, Integer> memo = new HashMap<>(Map.of(0, 0, 1, 1));
    static Map<Integer, Integer> memo = new HashMap<>();
    public static int fib1(int n){
        if( n < 2 ) return n;
        return fib1(n -1 ) + fib1( n -2);
    }

    public static int fib3(int n){
        if(!memo.containsKey(n)){
            memo.put(n, fib1(n -1 ) + fib1( n -2));
        }
        return memo.get(n);
    }

    // use for-loop
    public static int fib4(int n){
        int last = 0, next = 1; //fib(0), fib(1)

        for(int i=0; i < n; i++){
            int oldLast = last;
            last = next;
            next = oldLast + last;
        }

        return last;
    }



    public static void main(String[] args) {
        System.out.println(fib1(5));
        System.out.println(fib1(10));
        System.out.println(memo);
        System.out.println(fib3(40));

        System.out.println(fib4(40));



    }

}
