package com.hans;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author hans
 */
public class l0220_containsDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> set = new TreeSet<>();

        for(int i=0; i < nums.length; i++){

            Long floor = set.floor((long)nums[i]);
            Long ceiling = set.ceiling((long)nums[i]);

            if( (floor != null && nums[i] - floor <= t) ||
                ( ceiling != null && ceiling -nums[i] <= t )){
                return true;
            }

            set.add((long) nums[i]);

            if(set.size() == k+1){
                    set.remove( (long) nums[ i - 1 -k]);
            }

        }

        return false;
    }

}
