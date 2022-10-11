package com.hans.array;

public class L00334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 2){
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for( int n : nums){

            if ( n < first ){
                first = n;
            }

            if( n > first){
               second = Math.min(n, second);
            }

            if( n > second){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
