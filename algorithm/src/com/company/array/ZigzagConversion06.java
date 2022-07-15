package com.company.array;

public class ZigzagConversion06 {

    public static String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder res = new StringBuilder();
        int pattern = 2*numRows -2;
        int len = s.length();
        for(int i=0; i < numRows; i++){
            for(int j=i; j < len; j+=pattern ){
                res.append(s.charAt(j));
                int pos = j + pattern - (2 * i);
                if(i != 0 && i != numRows -1 && pos < len){
                    res.append(s.charAt(pos));
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        // PAYPALISHIRING
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
