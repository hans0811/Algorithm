package com.company.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L017LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();

        if(digits.length() ==  0){
            return res;
        }

        res.add("");

        for( int i=0; i < digits.length(); i++){
            List<String> temp = new ArrayList<>();
            String substr = map.get(digits.charAt(i));
            for(String str :res){
                for(int j=0; j < substr.length(); j++){
                    String strsum = str + substr.charAt(j);
                    temp.add(strsum);
                }
            }
            res = temp;
        }

        return res;
    }
    final static String[] map = new String[] {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static List<String> letterCombinationsBacktracking(String digits) {

        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        doCombination(new StringBuffer(), res, digits);
        return res;
    }

    private static void doCombination(StringBuffer str, List<String> res, String digits){

        if(str.length() == digits.length()){
            res.add(str.toString());
            return;
        }

        String substr = map[digits.charAt(str.length()) - '0'];
        for(char c: substr.toCharArray()) {
            str.append(c);
            doCombination(str, res, digits);
            str.deleteCharAt(str.length() - 1);
        }

    }

    public static void main(String[] args) {

        System.out.println(letterCombinations("234"));

        System.out.println(letterCombinationsBacktracking("234"));
    }
}
