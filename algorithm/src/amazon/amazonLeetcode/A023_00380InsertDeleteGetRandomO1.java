package amazonLeetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class A023_00380InsertDeleteGetRandomO1 {
    private ArrayList<Integer> arr = new ArrayList<>();
    private HashMap<Integer, Integer> map =new HashMap<>();
    private Random random = new Random();

    public void RandomizedSet() {
    }

    public boolean insert(int val) {

        if(map.containsKey(val)) return false;

        arr.add(val);
        int lastIndex = arr.size()-1;
        map.put(val, lastIndex);

        return true;

    }

    public boolean remove(int val) {

        if(!map.containsKey(val)) return false;

        Collections.swap(arr, map.get(val), arr.size()-1);


        int lastIndexKey = arr.get(map.get(val));
        map.put(lastIndexKey, map.get(val));

        arr.remove(arr.size()-1);
        map.remove(val);

        return true;

    }

    public int getRandom() {

        int randomIndex = random.nextInt(arr.size());
        return arr.get(randomIndex);

    }

}
