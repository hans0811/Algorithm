package com.company.array;

import java.util.*;

/**
 * @author hans
 */
public class L00937ReorderDatainLogFiles {
    public static String[] reorderLogFiles(String[] logs) {

        List<String> ans = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        List<String[]> letters = new ArrayList<>();


        for(String s : logs){

            int firstSpace = s.indexOf(' ');

            if(Character.isDigit(s.charAt( firstSpace + 1))){
                digits.add(s);
            }else{
                letters.add(new String[] { s.substring(0, firstSpace),
                        s.substring(firstSpace+1)});
            }

        }

        Collections.sort(letters, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]) == 0 ? o1[0].compareTo(o2[0]) : o1[1].compareTo(o2[1]);
            }
        });

        for(String[] s : letters){
            ans.add(s[0] + s[1]);
        }

        for(String s : digits){
            ans.add(s);
        }

        return ans.toArray(new String[0]);

    }

    public static void main(String[] args) {
        String[] s = new String[] {
                "a1 9 2 3 1",
                "g1 act car","zo4 4 7",
                "ab1 off key dog",
                "a8 act zoo"};
        System.out.println(reorderLogFiles(s));
    }


}
