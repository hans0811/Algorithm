package amazon;

import java.util.HashSet;
import java.util.Set;

public class A016_primemovieaward {

    public static int minimumGroups(int[] awards, int k){

        Set<Integer> set = new HashSet<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int award:awards){
            set.add(award);
            min = Math.min(min, award);
            max = Math.max(max, award);
        }

        int pointer = min;
        int count = 0;


        while(pointer <= max){

            for(int i=0; i<=k; i++){
                if(set.contains(pointer+i)){
                    pointer+=i;
                    count++;
                    break;
                }
            }

            pointer += k + 1;

        }

        return count;
    }

    public static void main(String[] args) {
        int[] awards1 = {1, 13, 6, 8, 9,3,5}; // 1, 3, 5, 6, 7, 8, 9, 13

        int[] awards2 = {3,1,4,3,9};

        System.out.println(minimumGroups(awards1, 4)); // 3
        System.out.println(minimumGroups(awards2, 10)); // 1
    }

}
