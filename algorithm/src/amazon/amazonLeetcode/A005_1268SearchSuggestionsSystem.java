package amazonLeetcode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class A005_1268SearchSuggestionsSystem {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);

        StringBuilder sb = new StringBuilder();

        char[] searchWordArray = searchWord.toCharArray();

        for(int i=0; i < searchWord.length(); i++){

            List<String> group = new ArrayList<>();

            for(int j=0; j < products.length && group.size() < 3; j++){

                if( searchWord.substring(0,i+1).equals(products[j].substring(0,i+1))){
                    group.add(products[j]);
                }
            }
            res.add(group);
        }
        return res;
    }

    public static List<List<String>> suggestedProductsBinarySearch(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        int l = 0, r = products.length-1;
        for(int i=0; i < searchWord.length(); i++){
            List<String> group = new ArrayList<>();
            char c = searchWord.charAt(i);
            while( l <= r && ( products[l].length() == i || products[l].charAt(i) < c )) l ++;
            while( l <= r && ( products[r].length() == i || products[r].charAt(i) > c )) r --;

            for(int j =0; j <3 && l + j <= r; j++){
                group.add(products[l+j]);
            }
            res.add(group);
        }

        return res;
    }



    public static void main(String[] args) {
        //String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String[] products = {"mouse", "moa"};
        String pattern = "yyyyMMdd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());

        System.out.println(date);
        System.out.println(Arrays.toString(suggestedProductsBinarySearch(products, "mouse").toArray()));
    }
}
