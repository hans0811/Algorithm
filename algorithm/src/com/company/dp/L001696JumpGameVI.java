package com.company.dp;

import java.util.PriorityQueue;

/**
 * @author hans
 */
public class L001696JumpGameVI {

    public static int maxResult(int[] nums, int k) {

        int n = nums.length, a=0, b=0;
        int[] deq = new int[n];
        deq[0] = n - 1;

        for(int i=n-2; i >=0; i--){
            if(deq[a] - i > k) a++;
            nums[i] += nums[deq[a]];
            while( b >= a && nums[deq[b]] <= nums[i]) b--;
            deq[++b] = i;
        }

        return nums[0];
    }

    public static void main(String[] args) {

        int[] nums01 = {1,-1,-2,4,-7,3};
        int k1 = 2;

        System.out.println(maxResult(nums01, k1));
    }
}
