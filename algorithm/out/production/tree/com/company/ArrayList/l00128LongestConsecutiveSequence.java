package algorithm.array;

import java.util.HashSet;

public class l00128LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        // discuss interviewer does it contain repeating numbers

        HashSet<Integer> set = new HashSet<>();

        for(int n: nums){
            set.add(n);
        }

        int longestStreak = 0;

        for(int num : set){
            if(!set.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;

                while(set.contains(currentNum+1)){
                    currentNum ++;
                    currentStreak ++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};

        System.out.println(longestConsecutive(nums));

    }

}
