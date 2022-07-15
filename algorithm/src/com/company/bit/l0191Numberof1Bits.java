package com.company.bit;

import java.util.HashSet;

/**
 * @author hans
 */
public class l0191Numberof1Bits {

    public static int hammingWeight(int n) {

        int bits = 0;
        int mask = 1;

        for(int i=0; i < 32; i++){

            if((n & mask) != 0){
                bits++;
            }

            mask <<=1;

        }

        return bits;
    }

    public static void main(String[] args) {

//        int i = -1073741825;
//
//        System.out.println(hammingWeight(i));
//
//        int j = 255;
//        System.out.println(Integer.toBinaryString(j));
//        System.out.println(Integer.bitCount(j));
//
//        int[] nums = {0,1,3,4};
//        int res = nums.length;
//        for(int k=0; k < nums.length; k++){
//            System.out.println(res);
//            res^=k^nums[k];
//            System.out.println(res);
//        }


        System.out.println((10 >>> 31));
        System.out.println((1 << 2));

        divide(10, 3);

        String s1 = "00110110";

        HashSet<Integer> set = new HashSet<>();

        System.out.println(s1.substring(0,2));

    }

    public static int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0;
        for (int x = 31; x >= 0; x--)
            if ((a >>> x) - b >= 0) {
                res += 1 << x;
                a -= b << x;
            }
        return (A > 0) == (B > 0) ? res : -res;
    }
}
