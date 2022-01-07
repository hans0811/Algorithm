package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class garbageCollection {

    public static void main(String[] args) {
        String example = "ccccc";

        int[] res = new int[26];

        for(int i=0; i < example.length(); i++){
            int idx = example.charAt(i) - 97;
            res[idx] += 1;
        }
        Integer max = Arrays.stream(res).max().getAsInt();
        System.out.println(max);

    }
}
