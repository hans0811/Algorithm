package com.hans.hackrank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hans
 */
public class array_001 {
    public static void main(String[] args) {

        List<Integer> ar = new ArrayList<>();
        ar.add(10);
        ar.add(20);
        ar.add(20);
        ar.add(10);
        ar.add(10);
        ar.add(30);
        ar.add(50);
        ar.add(10);
        ar.add(20);
        int[] count = new int[100];

        for(int i=0; i < ar.size(); i++){
            count[ar.get(i)] = count[ar.get(i)]+1;
        }

        System.out.println(ar);

        String step = "UDDDUDUU";

        for(int i=0; i< step.length(); i++){


            System.out.println(step.charAt(i));


        }

    }
}
