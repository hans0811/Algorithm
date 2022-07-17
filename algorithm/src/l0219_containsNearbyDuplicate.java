package com.hans;

import java.util.HashSet;

/**
 * @author hans
 */
public class l0219_containsNearbyDuplicate {

    public boolean containsDuplicate(int[] nums, int k) {

        HashSet<Integer> recode = new HashSet<>();

        // fix length
        for( int i=0; i<nums.length; i++){

            if(recode.contains(nums[i])){
                return true;
            }

            recode.add(nums[i]);

            if( recode.size() == k+1 ){
                recode.remove( nums[i-k]);
            }

        }

        return false;
    }

    public static void main(String[] args) {

    }

    // 217
}
