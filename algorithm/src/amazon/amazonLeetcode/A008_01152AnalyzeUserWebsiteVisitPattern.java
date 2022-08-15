package amazonLeetcode;

import java.util.*;

public class A008_01152AnalyzeUserWebsiteVisitPattern {

    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website){
        int n = timestamp.length;

        // 1. sort Session
        List<List<String>> session = new ArrayList<>();
        for(int i=0; i < n; i++){
            session.add(new ArrayList<>());
            session.get(i).add(username[i]);
            session.get(i).add("" + timestamp[i]);
            session.get(i).add(website[i]);
        }
        session.sort((a,b) -> Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1)));

        // 2. add each person visited list : name -> list web
        // joe - home, about
        Map<String, List<String>> visited = new HashMap<>();
        for(int i=0; i < n; i++){
            visited.putIfAbsent(session.get(i).get(0), new ArrayList<>());
            visited.get(session.get(i).get(0)).add( session.get(i).get(2));
        }

        // 3. find each user list and build all 3-sequences
        Map<String, Integer> sequenceMap = new HashMap<>();
        int maxCount = 0;
        String maxseq = "";
        for(String name : visited.keySet()){

            List<String> list = visited.get(name);
            if(list.size() < 3) continue;

            Set<String> subsequences = getSubsequences(list);

            for(String seq:subsequences){
                int count = sequenceMap.getOrDefault(seq, 0) +1;
                sequenceMap.put(seq, count);
                if(count > maxCount){
                    maxCount = count;
                    maxseq = seq;
                }else if(count == maxCount && seq.compareTo(maxseq) < 0){
                    maxseq = seq;
                }
            }
            String[] strs = maxseq.split(",");
            List<String> res = new ArrayList<>();
            for (String s: strs) {
                res.add(s);
            }

            return res;
        }

        return new ArrayList<>();
    }

    public static Set<String> getSubsequences(List<String> list){
        int n = list.size();
        Set<String> res = new HashSet<>();

        for(int i=0; i < n-2; i++){
            for( int j=i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    res.add(list.get(i) + "," + list.get(j) + "," + list.get(k));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};

        // Output: ["home","about","career"]

        // joe - 1 - home

        System.out.println(mostVisitedPattern(username, timestamp, website));

    }
}
