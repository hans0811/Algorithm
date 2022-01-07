package com.company.finonacci;

import java.lang.reflect.Array;

public class recursion {


    private static int[] arr;

    public static long recursion(long num){
        if(num == 0) return 0;
        if(num == 1) return 1;
        return recursion(num-1) + recursion(num-2);
    }


    public static long topDown(int num){

        arr = new int[(num+1)];

        return helpTopDown(num);
    }

    public static int helpTopDown(int num){

        if(num <= 0){
            return 0;
        }else if( arr[num] != 0){
            return arr[num];
        }else if (num == 1){
            return 1;
        }else{
            arr[num] = helpTopDown(num-1) + helpTopDown(num-2);

            return arr[num];
        }

    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(recursion(40));
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime));

        long startTime1 = System.currentTimeMillis();
        System.out.println(topDown(40));
        long endTime1 = System.currentTimeMillis();
        System.out.println((endTime1 - startTime1));


    }
}
