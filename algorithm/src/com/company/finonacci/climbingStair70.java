package com.company.finonacci;

public class climbingStair70 {

    // recursion
    public int climbStairsRecursion(int n) {

        if(n == 0){
            return 0;
        }else if( n ==1 ){
            return 1;
        }else if( n==2){
            return 2;
        }

        return climbStairsRecursion(n-1)+climbStairsRecursion(n-2);
    }



    // for
    public int climbStairs(int n) {

        if(n == 0){
            return 0;
        }else if( n ==1 ){
            return 1;
        }else if( n==2){
            return 2;
        }

        return climbStairs(n-1)+climbStairs(n-2);
    }

    public static int fib(int n){
        if (n < 1) return 0;
        if (n == 1 || n ==2 ) return 1;

        return fib(n-1) + fib(n-2);
    }

    // 0 - 0
    // 1 - 0,1
    // 2 - 0,1,1,2
    // 2 - 0,1,1,2,3
    // 3 - 0,1,1,2,3,5
    public static void main(String[] args) {
        int steps = 5;
        int firstItem = 0;
        int secondItem = 1;

        for(int i=1; i < steps; i++){
            int nextTerm = firstItem + secondItem;
            firstItem = secondItem;
            secondItem = nextTerm;
        }
        System.out.println(secondItem);

        System.out.println(fib(steps));

    }
}
