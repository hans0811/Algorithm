package amazon;

import java.util.ArrayList;

public class A010_MinNetPrice_minimumStock {

    public static int minimumStockPrice(int[] price){

        int[] difference = new int[price.length];
        int[] prefix = new int[price.length];
        prefix[0] = price[0];

        for(int i=1; i < price.length; i++){
            prefix[i] = prefix[i-1] + price[i];
        }

        ArrayList<Integer> arr = new ArrayList<>();


        for(int i=0; i < price.length-1; i++){
            int r = prefix[i] / (i+1);
            int l = (prefix[price.length-1] - prefix[i]) / (price.length-1-i);

            arr.add(Math.abs(l - r));

        }

        System.out.println(arr);

        int idx =0;
        int temp = arr.get(0);
        for(int i = 1; i<arr.size(); i++){

            if( temp > arr.get(i)){
                idx = i;
                temp= arr.get(i);
            }
        }

        return idx+1;
    }

    public static void main(String[] args) {
        int[] stockPrice01 = {1,3,2,4,5}; //2  { 1, 4, 6, 10, 15}
        int[] stockPrice02 = {1,1,1,1,1}; //1
        int[] stockPrice03 = {1,3,2,3}; //2

        System.out.println(minimumStockPrice(stockPrice03));
    }
}
