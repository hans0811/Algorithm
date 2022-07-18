package amazon;

import java.util.*;

public class A004_moveLocations {

    public static int[] moveLocations(int[] locations, int[] movedForm, int[] movedTo){

        Set<Integer> set = new HashSet<>();

        for(int n : locations){
            set.add(n);
        }

        for(int n : movedForm){

            if(set.contains(n)){
                set.remove(n);
            }else{
                set.add(n);
            }
        }

        for(int n : movedTo){

            if(set.contains(n)){
                set.remove(n);
            }else{
                set.add(n);
            }
        }

        int[] res = new int[set.size()];

        int idx = 0;
        for(int n : set){
            res[idx++] = n;
        }

        return res;

    }

    public static void main(String[] args) {

        // ans: 5,6,8,9
        int[] locations = {1,7,6,8};
        int[] movedFrom = {1,7,2};
        int[] movedTo = {2,9,5};



        System.out.println(Arrays.toString(moveLocations(locations, movedFrom, movedTo)));

    }
}
