package com.company.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses,
 * write a function to generate all combinations of well-formed parentheses.
 *
 * ex1
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * ex2
 * Input: n = 1
 * Output: ["()"]
 */
public class L0022GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n,n, "", res);
        return res;
    }

    public static void helper( int left, int right, String str, List<String> temp){

        if(left < 0 || right < 0 || left > right) return;

        if(left == 0 && right == 0){
            temp.add(str);
            return;
        }

        helper(left-1, right, str+"(", temp);
        helper(left, right-1, str+")", temp);

    }


    public static void main(String[] args) {

        List<String> a = generateParenthesis(2);

        System.out.println(a.toString());
    }

}
