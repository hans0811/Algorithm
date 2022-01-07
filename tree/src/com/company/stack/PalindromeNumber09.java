package com.company.stack;

import java.util.Stack;

public class PalindromeNumber09 {

    public boolean isPalindrome(int x) {

        Boolean result = false;
        int tmp = x;
        int after = 0;

        if( x < 0) return result;
        while( tmp != 0){
            after = after*10 + tmp%10;
            tmp /= 10;
        }

        if(after == x ){
            result = true;
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
