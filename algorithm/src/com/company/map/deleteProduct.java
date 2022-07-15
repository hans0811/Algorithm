package com.company.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class deleteProduct {

    public static int solution(int[] arr, int k){

        Map<Integer, Integer> map = new HashMap<>();

        for(int n:arr){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        System.out.println(map.toString());

        int size = map.size();
        int[] count = new int[size];

        int i = 0;
        for(int key:map.keySet()){
            count[i] = map.get(key);
            i++;
        }

        System.out.println(Arrays.toString(count));

        Arrays.sort(count);

        for(int c:count){
            if(k >= c){
               k -= c;
               size--;
            }else{
                break;
            }
        }

        return size;

    }

    public static void main(String[] args) {

        int[] case1 = {1,1,5,5};
        solution(case1, 2);
    }
}
