package algorithm.string;

import java.util.Arrays;

public class l000242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] dict = new int[26];


        for(int i=0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            dict[idx]++;
        }

        for(int j=0; j < t.length(); j++){
            int idx = t.charAt(j) - 'a';
            dict[idx]--;
        }

        System.out.println(Arrays.toString(dict));

        for(Integer n : dict){
            if( n != 0){
                return false;
            }
        }

        return true;
    }
}
