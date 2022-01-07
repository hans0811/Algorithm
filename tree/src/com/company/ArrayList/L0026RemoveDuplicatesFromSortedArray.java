package com.company.ArrayList;

public class L0026RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {

        if(nums.length==0)
            return 0;

        int prev = 0;

        for( int i=1; i < nums.length; i++){

            if(nums[prev] != nums[i]){
                prev++;
                nums[prev] = nums[i];
            }

        }

        return prev+1;
}


    public static void main(String[] args) {

        int[] case1 = {0,0,1,1,1,2,2,3,3,4};
    }

}
