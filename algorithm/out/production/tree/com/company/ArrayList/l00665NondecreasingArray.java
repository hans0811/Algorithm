package com.hans.array;

/**
 * @author hans
 */
public class l00665NondecreasingArray {

    public static boolean checkPossibility(int[] nums) {

        boolean changed = false;
        for(int i=1; i < nums.length; i++){

            if (nums[i-1] <= nums[i]){
                continue;
            }

            if (changed) return false;

            // decrease left element
            //  i-2 i-1  i
            // { 3,  4,  2 }
            // corner case if i is 0, i-2 will throw exception
            if(i==1 || nums[i] >= nums[i-2]){
                nums[i-1] = nums[i];
            }else{
                nums[i] = nums[i-1];
            }

            changed = true;
        }

        return true;

    }

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {4, 2, 3};

        System.out.println(checkPossibility(nums));
    }
}
