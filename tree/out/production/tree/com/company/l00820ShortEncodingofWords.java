package algorithm.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class l00820ShortEncodingofWords {
    public static int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));

        for(String word : words){
            for(int k=1; k < word.length(); k++){
                set.remove(word.substring(k));
            }
        }

        int res = 0;
        for(String word : set){
            res += word.length() + 1;
        }
        return res;

    }

    public static int findSameSubstring(String word1, String word2){


        for(int i=0; i < word1.length(); i++){
            int r = i+1;
            String temp = word1.substring(i,r);

            while(r <= word1.length()){
                temp = word1.substring(i,r);
                if(temp.equals(word2) && temp.length() > 1){
                    return 1;
                }
                r++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] str = {"timea", "me", "bell"};

        String a = "abcdefg";

        System.out.println(a.substring(1));
        System.out.println(minimumLengthEncoding(str));
    }




}
