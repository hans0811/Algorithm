package amazon;

import java.util.Arrays;

public class A012_L01846maximumElementAfterDecrementingAndRearranging {

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr){

        Arrays.sort(arr);

        if(arr[0] != 1){
            arr[0] = 1;
        }

        for(int i=1; i < arr.length; i++){
            if(Math.abs(arr[i] - arr[i-1]) > 1){
                arr[i] = arr[i-1] + 1;
            }
        }

        return arr[arr.length - 1];

    }

    public static void main(String[] args) {

    }
}