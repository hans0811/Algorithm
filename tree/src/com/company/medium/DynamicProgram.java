package com.company.medium;

import java.util.ArrayList;

public class DynamicProgram {

    public static int[] price = {1,5,8,9,10,17,17,20,24,30,
            30,30,30,30,30,30,30,30,30,30,
            30,30,30,30,30,30,30,30,30,30,
            30,30,30,30,30,30,30,30,30,30,
            30,30,30,30,30,30,30,30,30,30,
            30,30,30};
    private static int [] path;

    public static int dp(int length){
        if(length == 0)return 0;
        int result = Integer.MIN_VALUE;
        for(int i = 1; i <= length; i++){
            result = Math.max(result, price[i-1] + dp(length-i));
        }
        return result;
    }

    public static int bottomUpCutRod(int length){
        int[] dp = new int[length + 1];
        dp[0] = 0;
        for(int j=1; j <= length; j++){
            int max = Integer.MIN_VALUE;
            for(int i = 1; i<=j; i++){
                max = Math.max(max, price[i-1] + dp[j-i]);
            }
            dp[j] = max;
        }
        return dp[length];
    }

    public static int[] dp1;
    public static int extendedBottomUpCutRod (int n) {
        dp1 = new int[n+1];
        path = new int[n+1];
        dp1[0] = 0;

        for(int j=1; j<=n; j++){
            int max = Integer.MIN_VALUE;
            for(int i=1; i<=j; i++){
                if(max < (price[i-1] + dp1[j-i])){
                    max = price[i-1] + dp1[j-i];
                    path[j] = i;
                }
            }
            dp1[j] = max;
        }
        return dp1[n];
    }

    public static ArrayList<Integer> getACutSolution(int n){
        ArrayList<Integer> result = new ArrayList<>();
        while(n > 0){
            result.add(path[n]);
            n -= path[n];
        }
        return result;
    }

    public static void main(String[] args) {

        for(int i = 1; i <= price.length; i++){
            //System.out.println("length: " + i + " max:" + dp(i));
            //System.out.println("length: " + i + " max:" + bottomUpCutRod(i));
        }

        System.out.println("length: " + "7" + " max:" + extendedBottomUpCutRod(8));
        System.out.println(getACutSolution(8).toString());

    }
}
