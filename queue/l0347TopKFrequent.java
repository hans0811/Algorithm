package com.hans.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author hans
 */
public class l0347TopKFrequent {


    public int[] topKFrequent(int[] nums, int k) {

         Map<Integer, Integer> map = new HashMap<>();

         for(int i =0; i<nums.length; i++){
             map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
         }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (n1, n2)-> map.get(n1) - map.get(n2)
        );

         for(int num : map.keySet()){
             pq.offer(num);

             if(pq.size() > k){
                 pq.poll();
             }
         }

         int[] res = new int[k];

         for(int j=0; j < k; j++){
             res[j] = pq.poll();
         }

         return res;
    }
}
