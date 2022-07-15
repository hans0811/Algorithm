package com.company.tree.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hans
 */
public class l0131PalindromePartitioning {

    public static List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();

        if(s == null || s.length() == 0) return res;
        List<String> sub = new ArrayList<>();

        addPalindrome(s, 0, sub, res);

        return res;

    }

    public static void addPalindrome(String s, int idx, List<String> sub, List<List<String>> res){

        // basic case
        if(idx == s.length()){
            List<String> temp = new ArrayList<>(sub);
            res.add(temp);
            return;
        }

        for(int i=idx+1; i <= s.length(); i++){

            System.out.println( "idx: "  + idx + " String: " + s + " s length" + s.length());
            String subStr = s.substring(idx, i);
            System.out.println( "subString: " + subStr + " "+ idx + " " + i);

            if(isPalindrome(subStr)){
                sub.add(subStr);
                System.out.println("subList: " + sub.toString() + " size: "+ sub.size() );
                System.out.println("<<<<<<<<< Into");
                System.out.println("");
                addPalindrome(s, i, sub, res);

                System.out.println("");
                System.out.println("subList: " + sub.toString() + " size: "+ sub.size() );

                sub.remove(sub.size()-1);

                System.out.println("");
                System.out.println("subList: " + sub.toString() + " size: "+ sub.size() );
                System.out.println("out >>>>>>>>>");
            }
        }
    }

    public static boolean isPalindrome(String str){
        int l = 0;
        int r = str.length() - 1;

        while (l < r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String test = "aab";

        List<List<String>> a = partition(test);

        System.out.println();
        System.out.println(a.toString());

    }
}
