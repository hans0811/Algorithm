package com.hans.tree.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hans
 */
public class l0093RestoreIPAddress {

    public static List<String> res = new ArrayList<>();

    public static List<String> restoreIpAddresses(String s) {


        count(s, 0, "");

        return res;
    }



    public static void count(String s, int idx, String ans){

        // 0 0 0 0,  0, ""
        //

        if(s.length() > 3 *(4-idx)) return;

        System.out.println("<<<<<<<< idx " + idx + ">>>>>>>>>");
        System.out.println("the s");
        System.out.println(s);
        System.out.println("");
        System.out.println("the ans");
        System.out.println(ans);

        if( idx == 4){
            if(s.length() == 0){
                res.add(ans.substring(0, ans.length()-1));
            }
            return;
        }


        for(int i=1; i <=3; i++){

            // the rest of string cannot make ip
            if(s.length() < i) break;

            int val = Integer.parseInt(s.substring(0, i));

            if(val > 255 || i != String.valueOf(val).length()) continue;


            count( s.substring(i), idx+1, ans+s.substring(0,i) + ".");
        }

    }

    public static void main(String[] args) {

        String s = "25525511135";


        List<String> a = restoreIpAddresses(s);

        for(String n : a){
            System.out.println(a);
        }

    }

}
