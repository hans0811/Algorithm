package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */
public class L00184SUM {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 4) return ans;
        Arrays.sort(nums);
        for(int i=0; i < nums.length; i++){

            if( i>0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j=i+1; j<nums.length; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int twosum = target - nums[i] - nums[j];
                int l = j+1;
                int r = nums.length -1;

                while(l<r){
                    int sum = nums[l] + nums[r];
                    if(sum == twosum){
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[l]);
                        tmp.add(nums[r]);
                        ans.add(tmp);

                        while(l<r && nums[l+1] == nums[l]) l++;
                        while(l<r && nums[r-1] == nums[r]) r--;
                        l++;
                        r--;
                    }
                    else if (sum < twosum) l++;
                    else r--;
                }
            }
        }
        return ans;
    }
}

