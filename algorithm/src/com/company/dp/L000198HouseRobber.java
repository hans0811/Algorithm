package com.company.dp;

import java.util.Arrays;

/**
 * @author hans
 */
public class L000198HouseRobber {

    // memo[i] present biggest value in nums[i...n]
    public static int[] memo;

    public static int rob(int[] nums) {
        memo = new int[nums.length];

        Arrays.fill(memo, -1);

        return tryRob(nums, 0);
    }

    // nums[index...nums.size)
    public static int tryRob(int[] nums, int index){

        if(index >= nums.length) return 0;

        if(memo[index] != - 1) return memo[index];

        int res = 0;
        for(int i=index; i < nums.length; i++){
            res = Math.max(res, nums[i] + tryRob(nums, i+2));
            memo[index] = res;
        }

        return res;
    }

    /**
     * button up
     * O(n)
     * Follow up
     * 213, 337, 309
     * @param args
     */
    public static int rob_buttonUp(int[] nums) {

        int n = nums.length;
        if( n== 0 ) return 0;

        // memoDp[i] get biggest value in nums[i...n-1]
        int[] memoDp = new int[nums.length];
        Arrays.fill(memoDp, -1);

        memoDp[n-1] = nums[n-1];

        for( int i= n-2; i >= 0; i--){
            // memoDp[i]
            for( int j = i; j < n; j++){
                // if j + 2 > n, out of boundary
                memoDp[i] = Math.max( memoDp[i], nums[j] += j+2 < n ? memoDp[j+2] :0 );
            }
        }

        return memoDp[0];
    }




    public static void main(String[] args) {
        int[] house = {1,2,3,4};
        int[] house2 = {114,117,207,117,235,82,90,67,
                143,146,53,108,200,91,80,223,58,170,110,
                236,81,90,222,160,165,195,187,199,114,235,
                197,187,69,129,64,214,228,78,188,67,205,
                94,205,169,241,202,144,240};

        System.out.println(rob(house2));
    }


}
