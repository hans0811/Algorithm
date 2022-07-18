package amazon;

import java.util.HashMap;

/**
 * max average stock price
 * @author hans
 */
public class findMax {

    public static int findMax(int[] nums, int k){

        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i=0; i < n; i++){
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        return 0;

    }

    public static void main(String[] args) {
        int[] a1 = {1,2,3,4};


        System.out.println(findMax(a1, 2));
    }


}
