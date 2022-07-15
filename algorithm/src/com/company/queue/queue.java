package com.company.queue;

import java.util.HashMap;
import java.util.PriorityQueue;

public class queue {

    public static void main(String[] args) {

        // creating a priority queue
        PriorityQueue<Integer> numbers = new PriorityQueue<>();

        numbers.add(3);
        numbers.add(2);

        System.out.println(numbers);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,5);
        map.put(2,7);
//(a,b) -> a[1] +b[1]
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> 0);

        for(int key : map.keySet()){
            queue.offer(new int[] {key, map.get(key)});
        }

        System.out.println(queue);

    }
}
