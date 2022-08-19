package algorithm.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L00659SplitArrayIntoConsecutiveSubsequences {
    public static boolean isPossible(int[] nums) {

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int n : nums){
            if( !map.containsKey(n) ){
                map.put(n, new PriorityQueue<>());
            }

            if( map.containsKey(n-1)){
                int prevLength = map.get(n-1).poll();
                if(map.get(n-1).isEmpty()){
                    map.remove(n-1);
                }
                map.get(n).offer(prevLength + 1);
            }else{
                map.get(n).offer(1);
            }
        }

        for( Integer key : map.keySet()){
            if(map.get(key).peek() < 3){
                return false;
            }
        }

        return true;
    }

    public boolean isPossible2Maps(int[] nums) {
        Map<Integer,Integer> possibility = new HashMap<>();
        Map<Integer,Integer> counts = new HashMap<>();
        for(int num:nums){
            counts.put(num,counts.getOrDefault(num,0)+1);
        }
        for(int num:nums){
            if(counts.get(num)==0)continue;
            if(possibility.getOrDefault(num,0)>0){
                possibility.put(num,possibility.getOrDefault(num,0)-1);
                possibility.put(num+1,possibility.getOrDefault(num+1,0)+1);
            }
            else if( counts.getOrDefault(num+1,0)>0 && counts.getOrDefault(num+2,0)>0 ){
                possibility.put(num+3,possibility.getOrDefault(num+3,0)+1);
                counts.put(num+1,counts.getOrDefault(num+1,0)-1);
                counts.put(num+2,counts.getOrDefault(num+2,0)-1);
            }
            else{
                return false;
            }
            counts.put(num,counts.get(num)-1);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,3,4,5};


        System.out.println(isPossible(nums));
    }
}
