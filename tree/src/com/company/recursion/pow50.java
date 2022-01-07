package com.company.recursion;

public class pow50 {
    public static double myPow(double x, int n) {
        double result = 1.0;
        for(int i=0; i < Math.abs(n); i++){
            if(n > 0){
                result *= x;
            }else{
                result /= x;
            }
        }
        return result;
    }


    public static double myPowRecursion(double x, int n){

        if( n == 0){
            return 1.0;
        }

        if( n < 0 ){
            n = -n;
            x = 1 / x;
            if(-n == Integer.MIN_VALUE){
                return x * myPow(x, (n-1));
            }
        }

        return (n%2 == 0) ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }

    public static void main(String[] args) {

        //System.out.println(myPow(2.100, 3));
        System.out.println(myPowRecursion(2.00000, 10));

    }


}
