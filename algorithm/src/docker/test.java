package com.hans.docker;

import java.util.Arrays;

/**
 * @author hans
 */
public class test {

    public static void main(String[] args) {

        int[] arr = {1, 0, 1};

        int lsum = 0;
        int rsum = 0;

        // 1, 0, 1, 2
        for(int i=1; i<arr.length; i++){
            rsum += arr[i];
        }

        for(int i=0; i< arr.length; i++){

            if(rsum == lsum){
                System.out.println(i);
            }else{

                lsum += arr[i];
                rsum -= arr[i+1];

            }
        }

        System.out.println(-1);



        Arrays.sort(arr);
        int difference = arr[1]-arr[0];

        for(int i=2; i<arr.length; i++){
            difference = Math.min(difference, arr[i]-arr[i-1]);
        }

        for(int i=1; i<arr.length; i++){
            if( arr[i-1] - arr[i] == difference){
                System.out.println(arr[i-1] + " "+ arr[i]);
            }
        }





    }
}
