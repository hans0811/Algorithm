package com.company.ArrayList;

import java.lang.reflect.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given an integer array nums, return all the triplets
 [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
 and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
 */

public class L00153SUM {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0; i < nums.length-2 ; i++){

            int l = i +1;
            int r = nums.length -1;
            int target = 0 - nums[i];

            while(l < r){

                int sum = nums[l]+nums[r];

                if ( sum == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l] == nums[l-1]){
                        l++;
                    }
                    while(l<r && nums[r] == nums[r+1]){
                        r--;
                    }
                }else if(sum < target){
                   // l++;
                    r--;
                }else{
                    l++;
                    //r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] case1 = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(case1));

    }
}
