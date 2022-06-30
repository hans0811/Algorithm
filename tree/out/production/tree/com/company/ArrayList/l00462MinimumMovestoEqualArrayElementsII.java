package algorithm.array;

import java.util.Arrays;

public class l00462MinimumMovestoEqualArrayElementsII {
    public static int minMoves2(int[] nums) {

        Arrays.sort(nums);
        int mid = nums[nums.length >> 1];
        int count = 0;
        for(int n : nums){
            count += Math.abs(n - mid);
        }
        return count;
    }


    public static void main(String[] args) {

        
        int[] nums = {1,2,3};

        int[] nums1 = {1,10,2,9};

        int[] nums2 = {1,0,0,8,6};

        System.out.println(minMoves2(nums2));
    }



}
