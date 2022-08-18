package algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L01338ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int a :  arr ){
            map.put(a , map.getOrDefault(a, 0) + 1);
        }

        if(map.size() <= 2) return 1;

        int[] total = new int[map.size()];

        int idx = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            total[idx] = entry.getValue();
            idx++;
        }

        // [4,3,2,1]
        // targer = 5 (10/2) ;

        Arrays.sort(total);

        System.out.println(Arrays.toString(total));
        int size = arr.length / 2;
        int count = 0;
        for(int i=total.length - 1; i > 0; i--){
            size -= total[i];
            count++;

            if(size <= 0){
                return count;
            }
        }
        return count;
    }

    public static int minSetSize_MapAndQuee(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int n : arr){
            map.put(n, map.getOrDefault(n, 0) + 1);
            Math.max(max, n);
        }
        if(map.size() <= 2 ) return 1;


        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        for(int n : map.keySet()){
            pq.offer(map.get(n));
        }

        int res = 0;
        int sum = 0;

        while( !pq.isEmpty() ){
            sum += pq.poll();
            res++;
            if(sum >= arr.length / 2){
                return res;
            }
        }

        return -1;
    }

    public static int minSetSize_OnlyArray(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int n : arr){
            map.put(n, map.getOrDefault(n, 0) + 1);
            max = Math.max(max, n);
        }
        if(map.size() <= 2 ) return 1;

        int[] dict = new int[max+1];
        for(int n : arr){
            dict[n]++;
        }
        System.out.println();

        Arrays.sort(dict);

        int target = arr.length/2;
        int res = 0;

        for(int i=dict.length-1; i > 0; i--){
            target -= dict[i];
            res++;
            if(target <= 0){
                return res;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3,3,3,3,5,5,5,2,2,7,9,9,9,9,9,9,9};

        System.out.println(minSetSize_MapAndQuee(nums));

    }
}
