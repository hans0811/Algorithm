package com.company.dp.hard;

import java.util.Arrays;

/**
 * @author hans
 */
public class L0354RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {

        // corner case
        if(envelopes.length < 2) return envelopes.length;

        Arrays.sort(envelopes, (a,b) -> a[0] == a[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] dp = new int[envelopes.length];
        int size = 0;

        for(int[] e : envelopes){
            int left = 0;
            int right = size;
            while(left < right){

                int mid = left + (right - left) / 2;

                if(dp[mid] < e[1]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            dp[left] = e[1];
            if(left == size){
                size++;
            }
        }
        return size;
    }
}
