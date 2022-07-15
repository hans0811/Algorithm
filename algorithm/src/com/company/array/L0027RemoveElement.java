package com.company.array;

/**
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class L0027RemoveElement {

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return nums.length;

        int prev = 0;

        for(int i=1; i < nums.length; i++){

            if(nums[i] != val){
                nums[prev++] = nums[i];
            }
        }
        return prev+1;
    }

    public static void main(String[] args) {

    }
}
