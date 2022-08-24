package algorithm.power.L00326PowerOfThree;

public class L00326PowerOfThree {
    public boolean isPowerOfThree(int n) {

        if( n < 1 ) return false;

        while( n % 3 == 0 ){
            n /= 3;
        }

        return n == 1;
    }
}
