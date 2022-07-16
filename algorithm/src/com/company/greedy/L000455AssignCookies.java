package com.company.greedy;

import java.util.Arrays;
import java.util.Collections;


/**
 * @author hans
 */
public class L000455AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int si = 0, gi = 0;

        while( gi < g.length && si < s.length){

            if(s[si] < g[gi]){
                si++;
            }else{
                si++;
                gi++;
            }
        }
        return gi;
    }

    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};


        System.out.println(findContentChildren(g,s));
    }

}
