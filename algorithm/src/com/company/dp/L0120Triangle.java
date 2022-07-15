package com.company.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hans
 */
public class L0120Triangle {


    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1];

//        for(int i=0; i < triangle.get(triangle.size()-1).size(); i++){
//            dp[i] = triangle.get(triangle.size()-1).get(i);
//        }

        for(int i=triangle.size()-1; i >=0; i-- ){

            for(int j=0; j < triangle.get(i).size(); j++){
                System.out.println(Arrays.toString(dp));
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }


        }

        return dp[0];

    }



    public static void main(String[] args) {

        List<List<Integer>> t = new LinkedList<>();

        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();
        List<Integer> l3 = new LinkedList<>();
        List<Integer> l4 = new LinkedList<>();
        List<Integer> l5 = new LinkedList<>();

        l1.add(2);

        l2.add(3);
        l2.add(4);

        l3.add(6);
        l3.add(5);
        l3.add(7);

        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        t.add(l1);
        t.add(l2);
        t.add(l3);
        t.add(l4);

        minimumTotal(t);

    }
}
