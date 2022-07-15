package com.company.array;

public class L0011ContainerWithMostWater {


    public static int maxArea(int[] height) {

        int r = height.length - 1;
        int l = 0;
        int max = 0;

        while( r < l){

            max = Math.max(max, (r-l) * Math.min(height[l], height[r]));

            if(height[l] < height[r]){
                l++;
            }else{
                r++;
            }
        }

        return max;
    }

    public static void main(String[] args) {


    }
}
