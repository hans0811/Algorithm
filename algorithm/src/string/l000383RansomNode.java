package algorithm.string;

import java.util.HashMap;

public class l000383RansomNode {
    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] dict = new int[26];

        for(int i=0; i < magazine.length(); i++){
            dict[ magazine.charAt(i) - 'a'] ++;
        }

        for(int j=0; j < ransomNote.length(); j++){
            if( --dict[ ransomNote.charAt(j) - 'a'] < 0 ){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String ransomeNote = "aa";
        String magazine = "aab";

        System.out.println(canConstruct(ransomeNote, magazine));
    }
}
