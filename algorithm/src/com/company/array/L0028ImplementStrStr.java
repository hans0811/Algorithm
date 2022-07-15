package com.company.array;

public class L0028ImplementStrStr {

    public static int strStr(String haystack, String needle) {

        int range = haystack.length()-needle.length();

        if(needle.length()<=0) return 0;
        if(haystack.length()<=0 || range < 0) return -1;

        Boolean match = false;

        for(int i=0; i < range+1 ; i++){

            if( haystack.charAt(i) == needle.charAt(0)){
                match = true;
                for(int j=1; j < needle.length(); j++){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        match=false;
                        break;
                    }
                }
                if(match) return i;
            }
        }
        return -1;
    }

    public static int strStrFor(String haystack, String needle){

        if(needle.length() == 0) return 0;
        if(haystack.length() <0 || needle.length() > haystack.length()) return -1;


        for(int i=0; i <= haystack.length()-needle.length(); i++){
            if(needle.equals(haystack.substring(i, needle.length()+i))){
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        String a = "hello";
        String b = "ll";

        String c1 = "aaaaa";
        String c2 = "bba";


        System.out.println(strStrFor(c1,c2));
    }
}
