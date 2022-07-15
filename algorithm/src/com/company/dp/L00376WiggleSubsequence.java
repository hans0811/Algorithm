package com.company.dp;

import java.util.HashMap;

/**
 * @author hans
 */
public class L00376WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1) return nums.length;

        int len = nums.length;
        int[] down = new int[len];
        int[] up = new int[len];
        down[0] = 1;
        up[0] = 1;

        for(int i=1; i < len; i++){
            if(nums[i] > nums[i-1]){
                down[i] = down[i-1];
                up[i] = down[i-1] + 1;
            }else if(nums[i] < nums[i-1]){
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            } else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }

        return Math.max(down[len-1], up[len-1]);
    }

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println('a'+1);
        System.out.println(( int)('a') - (int)key.charAt(0));
        System.out.println((int)key.charAt(0));

        // 48

        HashMap<Character, Character> map = new HashMap<>();
        int count =97;
        for(int i=0; i < key.length(); i++){

            if(!map.containsKey(key.charAt(i)) && key.charAt(i) != ' ' ){
                char c = (char) (count);
                map.put(key.charAt(i), Character.valueOf(c));
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i < message.length(); i++){
            if(  map.get(message.charAt(i)) != null){
                sb.append( map.get(message.charAt(i)));
            }else{
                sb.append(' ');
            }

        }

        System.out.println(sb.toString());
    }



}
