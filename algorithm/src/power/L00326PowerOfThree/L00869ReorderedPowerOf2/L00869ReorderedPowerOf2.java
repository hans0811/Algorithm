package algorithm.power.L00869ReorderedPowerOf2;

import java.util.Arrays;

public class L00869ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int n) {

        char[] dict = String.valueOf(n).toCharArray();
        Arrays.sort(dict);
        // restriction is power of 30

        for( int i=0; i < 30; i++){
            char[] res = String.valueOf( 1 << i).toCharArray();
            Arrays.sort(res);
            if(Arrays.equals(dict, res)) return true;
        }

        return false;
    }

}
