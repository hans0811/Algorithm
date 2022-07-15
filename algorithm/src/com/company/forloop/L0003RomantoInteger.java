package com.company.forloop;

import java.util.HashMap;
import java.util.Map;

public class L0003RomantoInteger {

    public static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int sum = 0;
        sum += map.get(s.charAt(0));
        for(int i=1; i < s.length(); i++){
            sum += map.get(s.charAt(i));
            if( map.get(s.charAt(i)) > map.get(s.charAt(i-1)) ){
                sum -= map.get(s.charAt(i-1)) *2;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}
