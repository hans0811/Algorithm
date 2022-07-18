package amazon;

import java.util.HashMap;
import java.util.Map;

public class deliverPackageWithBox {

    public static int deliverPackageWithBox(int[] weight){

        HashMap<Integer, Integer>  map = new HashMap<>();

        for(int i=0; i < weight.length; i++){
            map.put(weight[i], map.getOrDefault(weight[i],0) + 1);
        }

        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            if(entry.getValue() % 3 != 0 && entry.getValue() % 2 != 0){
                return -1;
            }

            if(entry.getValue() % 3 == 0){
                count += entry.getValue() / 3;
            }

            if(entry.getValue() % 2 == 0){
                count += entry.getValue() / 2;
            }

        }

        return count;

    }

    public static void main(String[] args) {
        int[] weight1 = {2,4,6,6,4,2,4};
        int[] weight2 = {2,3,3};
        System.out.println(deliverPackageWithBox(weight2)); // 3
    }
}
