package amazonLeetcode;

import java.util.*;

public class A007_00051GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){

            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortString = new String(c);

            if(!map.containsKey(sortString)){
                List<String> group = new ArrayList<>();
                group.add(s);

                map.put(sortString,group);
            }else{
                map.get(sortString).add(s);
            }

        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public List<List<String>> groupAnagramsOrder(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){

            int[] count = new int[26];

            for(int i=0; i < s.length(); i++){
                count[s.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for(int i =0; i < 26; i++){
                if(count[i] == 0) continue;
                for(int j=count[i]; j >=0; j--){
                    sb.append(i + 'a');
                }

            }

            String temp = sb.toString();

            if(!map.containsKey(temp)){
                List<String> group = new ArrayList<>();
                group.add(s);
                map.put(temp, group);
            }else{
                map.get(temp).add(s);
            }

        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println();
    }
}
