package com.company.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PalindromeNumber20 {

    public static boolean isValid(String s) {

        if(s.length() <= 1) return false;
        boolean res = true;
        Stack<Character> left = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('(', ')');
        map.put('[',']');

        for(Character c: s.toCharArray()) {

            if (c == '{' || c == '(' || c == '[') {
                left.push(c);
            } else if (c == '}' && !left.empty() && left.peek() == '(') {
                left.pop();
            } else if (c == '}' && !left.empty() && left.peek() == '{') {
                left.pop();
            } else if (c == ']' && !left.empty() && left.peek() == '[') {
                left.pop();
            } else {
                return false;
            }
        }
        return left.empty();
    }

    public static void main(String[] args) {

        String case1 = ")(){}"; //"){", "((", "()", ")(){}", "){"

        System.out.println(isValid(case1));

    }
}
