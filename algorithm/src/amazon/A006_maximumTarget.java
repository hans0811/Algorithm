package amazon;

import java.util.HashMap;

public class A006_maximumTarget {

    public static void main(String[] args) {

//        String s = "mononom";
//        String t = "mon";

        String s = "abacbc";
        String t = "bca";

        HashMap<Character, Integer> mapS = new HashMap<>();

        for(int i=0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(!mapS.containsKey(c)){
                mapS.put(c, mapS.getOrDefault(c,0) + 1);
            }else{
                mapS.put(c, mapS.get(c) + 1);
            }
        }

        int res = Integer.MAX_VALUE;
        int count = 0;
        //if(mapS.size() < t.length()) return 0;

        for(int i=0; i < t.length(); i++){

            if( mapS.containsKey(t.charAt(i))){
                count++;
            }

            res = Math.min(res, mapS.getOrDefault(t.charAt(i),0));

        }

        System.out.println(res);




    }
}
