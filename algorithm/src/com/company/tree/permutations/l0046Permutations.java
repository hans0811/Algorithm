package com.company.tree.permutations;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hans
 */
public class l0046Permutations {

    public static List<List<Integer>> res = new LinkedList<>();
    public static boolean[] used;


    public static List<List<Integer>> permute(int[] nums) {

        if( nums.length == 0) return res;

        List<Integer> p = new LinkedList<>();
        used = new boolean[nums.length];

        generatePermutations(nums, 0, p);

        return res;
    }

    // p have elements of index
    // index+1, get index + 1 of permuntations
    public static void generatePermutations(int[] nums, int idx, List<Integer> p){
        if( idx == nums.length){
            List<Integer> temp = new LinkedList<>(p);
            res.add(temp);
            return;
        }

        for(int i =0; i<nums.length; i++){
            // check nums[i] in the p
            if( !used[i] ){ // reset used[i]
                p.add(nums[i]);
                used[i] = true;
                generatePermutations(nums, idx + 1, p);
                p.remove(p.size()-1);
                used[i] = false;
            }

        }
    }

    public static void main(String[] args) {

        int[] a = new int[]{1,2,3};

        List<List<Integer>> abc = permute(a);

        System.out.println(abc.toString());
    }
}
