package com.company.hackerrank;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an Array of bad numbers and a range of integers, how can I determine the
 * longest segment of integers within that inclusive range that doesn't contain
 * a bad number?
 *
 * For example, you are given the lower limit l = 3 and the upper limit r = 48,
 * The array badNumbers = [37,7,22,15,49,60]. Segments without bad numbers are
 * [3,6], [8,14], [16,21],[23,36] and [38,48].
 * The longest segment is [23,36] and it is 14 elements long.
 */
public class goodSegment {

    public static int solution(int l, int r, int[] badNumbers){
        Arrays.sort(badNumbers);
        ArrayList<Integer> ans = new ArrayList<>();

        // 3,48
        // [7,15,22,37,49,60]
        int temp = Integer.MIN_VALUE;

        for(int i=0; i<badNumbers.length; i++){
            if( badNumbers[i] > r){
                ans.add(r);
                break;
            }
            for( int j=0; j <= badNumbers[i]; j++){

                if( j == badNumbers[i] ){
                    ans.add(j-1);
                    ans.add(j+1);

                }else if(j == l && ans.size() == 0){
                    ans.add(j);
                }
            }
        }

        int higestNum = Integer.MIN_VALUE;
        for(int i=0; i<ans.size()-1; i+=2){
            System.out.println(ans.get(i+1)-ans.get(i));
            higestNum = Math.max(higestNum,  ans.get(i+1)-ans.get(i));
        }

        System.out.println(ans.toString());


        return 0;
    }

    public static void main(String[] args) {
        int[] a = {37,7,22,15,49,60};


        solution(3,48, a);

    }
}
