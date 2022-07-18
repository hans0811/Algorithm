package amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class subArrayMax {


    public static long subArrayRanges(int[] nums) {
        int len = nums.length;
        int j, k;
        long res = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i =0; i <= len; i++){
            int cur = i == len ? Integer.MIN_VALUE : nums[i];

            while(!stack.isEmpty() && cur < nums[stack.peek()]){
                j = stack.pop();
                k = stack.isEmpty() ? -1 : stack.peek();
                res -= (long) nums[j] * (i-j) * (j-k);
            }

            stack.push(i);

        }

        stack.clear();

        for(int i=0; i <= len; i++){
            int cur = i == len ? Integer.MAX_VALUE : nums[i];

            while(!stack.isEmpty() && cur > nums[stack.peek()]){
                j = stack.pop();
                k = stack.isEmpty() ? -1 : stack.peek();
                res += (long) nums[j] * (i-j) * (j-k);
            }

            stack.push(i);
        }


        return res;

    }


    public static void main(String[] args) {

        int[] nums = {1,2,3};

        System.out.println(subArrayRanges(nums));
    }
}
