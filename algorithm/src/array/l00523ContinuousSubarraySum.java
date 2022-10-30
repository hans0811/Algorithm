package com.hans.array;

import java.util.HashSet;

public class l00523ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        for(int i=0; i < nums.length; i++){
            int sum = nums[i];

            for(int j=i+1; j < nums.length; j++){
                sum += nums[j];

                if( sum == k ) return true;
                if(k != 0 && sum % k == 0 ) return true;
            }
        }
        return false;
    }

    public static boolean checkSubarraySumUsingSet(int[] nums, int k){
        int n = nums.length, sum=0, pre=0;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i < n; i++){
            sum += nums[i];
            int t = (k==0) ? sum : (sum % k);
            if(set.contains(t)) return true;
            set.add(pre);
            pre = t;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] case01 = {23,2,6,4,7};
        System.out.println(checkSubarraySumUsingSet(case01, 13));
    }
}
