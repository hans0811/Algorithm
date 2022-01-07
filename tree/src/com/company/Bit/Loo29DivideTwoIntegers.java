package com.company.Bit;

public class Loo29DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if(dividend == divisor) return 0;
        int temp =dividend;
        int tempDivisor = Math.abs(divisor);
        for( int i=0; i < Math.abs(dividend); i++){
            temp -= tempDivisor;
            if( temp < 0 && dividend > 0 ) {
                return divisor > 0 ? i : -i;
            }else if(temp < 0 && dividend < 0){
                return divisor > 0 ? i : -i;
            }
        }
        return 0;
    }

    public static int divideBitMultiple(int dividend, int divisor) {

        if(divisor == 0 || (dividend == Integer.MIN_VALUE && dividend == -1)) {
            return Integer.MAX_VALUE;
        }

        int sign = (dividend >0 && divisor <0) || (dividend < 0 && divisor >0) ? -1 : 1;
        int quotient = 0;

        long absoluteDividend = Math.abs((long) dividend);
        long absoluteDivisor = Math.abs((long) divisor);

        while(absoluteDividend >= absoluteDivisor){

            int shift = 0;
            while( absoluteDividend >= (absoluteDivisor << shift)){
                shift++;
            }

            // Add the number of times we shifted to the quotient
            quotient += (1 << (shift - 1));
            // Update the dividend for the next iteration
            absoluteDividend -= absoluteDivisor << (shift - 1);

        }
        return sign == -1 ? -quotient : quotient;
    }



    public static void main(String[] args) {

        System.out.println(divideBitMultiple(7, -3));

    }
}
