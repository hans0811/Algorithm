package tree.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hans
 */
public class l0017LetterCombinationsofaPhoneNumber {

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits=="") return res;

        findCombination(digits, 0, "");

        return res;

    }

    public String[] letterMap = {
        " ", //0
        "", //1
        "abc", //2
        "def", //3
        "ghi", //4
        "jkl", //5
        "mno", //6
        "pqrs", //7
        "tuv", //8
        "wxyz" //9
    };
    // s save digits[0...index-1]
    // find matching digits[index]
    public void findCombination(String digits, int index, String s){

        if(index == digits.length()){
            // save s;
            res.add(s);
            return;
        }

        char c = digits.charAt(index);
        String letters = letterMap[c-'0'];

        for( int i=0; i<letters.length(); i++){
            findCombination(digits, index+1, s+letters.charAt(i));
        }

    }


}
