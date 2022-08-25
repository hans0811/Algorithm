package amazon;

import java.util.HashMap;
import java.util.Map;

/**
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

        int res = -1;
        if(map.size() == k){
            res = sum;
        }

        for(int i=k; i< n; i++){

            map.put(nums[i-k], map.get(nums[i-k]) -1 );
            if(map.get(nums[i-k]) == 0){
                map.remove(nums[i-k]);
            }

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum = sum - nums[i-k] +nums[i];

            if(map.size() == k){
                res = Math.max(res, sum);
            }


        }

        return res;

    }

    public static int findMax01(int[] stocks, int k){

        if (stocks.length == 0 || k == 0) return 0;
        int res = 0, start = 0, count = 0, cur = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // stock => pos
        for(int i = 0; i < stocks.length; i++) {
            if (map.containsKey(stocks[i])) {
                int finalStart = map.get(stocks[i]);
                while(start <= finalStart) {
                    cur -= stocks[start];
                    map.remove(stocks[start]);
                    count--;
                    start++;
                }
            }
            if (count < k) {
                    cur += stocks[i];
                    count++;
                    map.put(stocks[i], i);
                    if (count == k) {
                        res = Math.max(res, cur);
                    }
            } else {
                    cur += stocks[i] - stocks[start];
                    map.put(stocks[i], i);
                    map.remove(stocks[start]);
                    start++;
                    res = Math.max(res, cur);
            }

        }
        return res;

    }

    public static void main(String[] args) {
        int[] a1 = {1,2,7,7,4,3,6};


        System.out.println(findMax(a1, 3));
        System.out.println(findMax01(a1, 3));
    }


}
