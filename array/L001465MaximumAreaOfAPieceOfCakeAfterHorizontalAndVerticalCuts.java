package com.hans.array;

import java.util.Arrays;

/**
 * @author hans
 */
public class L001465MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        // Need to check the array is inorder
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        // In case the ans bigger than 10^9 + 7
        int MOD = (int) Math.pow(10,9) + 7;

        // corner Case
        int maxH = Math.max(horizontalCuts[0], h-horizontalCuts[horizontalCuts.length-1]);
        int maxV = Math.max(verticalCuts[0], w-verticalCuts[verticalCuts.length-1]);


        // find Biggest difference between horizontalCuts
        for(int i=1; i < horizontalCuts.length; i++){
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i-1]);
        }

        for(int i=1; i < verticalCuts.length; i++){
            maxV = Math.max(maxV, verticalCuts[i]-verticalCuts[i-1]);
        }

        return (int)((long) maxH * maxV % MOD);


    }

    public static void main(String[] args) {

    }
}
