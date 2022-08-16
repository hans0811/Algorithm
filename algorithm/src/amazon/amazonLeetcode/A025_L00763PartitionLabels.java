package amazonLeetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class A025_L00763PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        int size = s.length();
        for(int i=0; i < size; i++){
            map.put(s.charAt(i), i);
        }
        int start= 0;
        int last =0;
        for(int j=0; j < size; j++){
            last = Math.max(last, map.get(s.charAt(j)));
            if( j == last){
                res.add(j - start + 1);
                start = j + 1;
            }
        }

        return res;
    }
}
