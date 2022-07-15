package com.company.array;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target,
 * find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 *
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 *
 */
public class L00163SUM_Closest {

    public static int threeSumClosestV2(int[] nums, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(nums);

        int closet = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closet - target);

        for(int i=0;  i < nums.length - 2; i++){
            int l = i+1;
            int r = nums.length - 1;

            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target ){
                    return sum;
                }else if( sum < target){
                    res.add(sum);
                    l++;
                }else{
                    res.add(sum);
                    r--;
                }
            }
        }

//        int diff = Integer.MAX_VALUE;
//        int ans=0;
//        for(int number: res ){
//
//            if( Math.abs((number - target)) < diff ){
//                ans = number;
//                diff = Math.abs((number - target));
//            }
//        }

        return 0;
    }

    public static int threeSumClosest(int[] nums, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;  i < nums.length - 2; i++){
            int l = i+1;
            int r = nums.length - 1;

            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target ){
                    return sum;
                }else if( sum < target){
                    res.add(sum);
                    l++;
                }else{
                    res.add(sum);
                    r--;
                }
            }
        }

        int diff = Integer.MAX_VALUE;
        int ans=0;
        for(int number: res ){

            if( Math.abs((number - target)) < diff ){
                ans = number;
                diff = Math.abs((number - target));
            }
        }

        return ans;
    }

        public static void main(String[] args) {

        int[] case1 = {-1,2,1,-4};
        int[] case2 = {0,0,0,0};


        System.out.println(threeSumClosest(case2, 1));
    }
}
