package algorithm.DP;

import java.util.Arrays;

public class L00473MatchstickstoSquare {

    public static boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4) return false;

        int sum = Arrays.stream(matchsticks).sum();
        if(sum % 4 != 0) return false;

        int[] sums = new int[matchsticks.length];
        Arrays.sort(matchsticks);

        return helper(matchsticks, sums, 0, sum/4);
    }

    public static boolean helper(int[] nums, int[] sums, int pos, int target){

        if(pos >= nums.length) {
            return sums[0] == target && sums[1] == target && sums[2] == target;
        }

        for(int i=0; i < 4; i++){
            if(sums[i] + nums[pos] > target) continue;
            sums[i] += nums[pos];
            if(helper(nums, sums, pos + 1, target)) return true;
            sums[i] -= nums[pos];
        }

        return false;
    }



    public static void main(String[] args) {

    }

}
