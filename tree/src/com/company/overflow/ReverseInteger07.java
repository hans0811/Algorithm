package com.company.overflow;

public class ReverseInteger07 {

    public static int reverse(int x) {
        int result = 0;
        if( x == 10 ) return 1;

        boolean negative =  x < 0 ? true : false;
        x=Math.abs(x);

        while( x != 0){

            int tmpResult = (result * 10) + (x % 10);

            if(tmpResult/10 != result ){
                return 0;
            }else{
                result = result * 10 + x%10;
                x /= 10;
            }
        }

        return negative ? -(result): result ;
    }

    public static void main(String[] args) {

        int pig = (short)4;

        pig = ++pig;

        System.out.println(pig);
        short height = 1, weight = 3;
        double zebra =  weight *  height;

        System.out.println(reverse(-123456));
    }
}
