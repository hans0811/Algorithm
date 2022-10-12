package com.hans.array;

import java.util.Arrays;

public class L00976LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        int max = 0;

        Arrays.sort(nums);

        for( int i=0; i < nums.length-2; i++){
            int sum = nums[i] + nums[i+1];
            if( nums[i] + nums[i+1] > nums[2]){
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
