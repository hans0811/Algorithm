package algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
}
