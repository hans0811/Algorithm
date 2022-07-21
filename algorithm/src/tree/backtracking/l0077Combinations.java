package tree.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hans
 */
public class l0077Combinations {

    public static List<List<Integer>> res;

    public void generateCombinations(int n, int k, int start, List<Integer> comb){

        if( comb.size() == k){
            List<Integer> temp = new LinkedList<>(comb);
            res.add(temp);
            return;
        }

        // k - comb.size() spaces, at least k-comb.size() element in [i...n]
        // k-comb.size() = 1 then i = n
        // k-comb.size() = 2 then i = n-1
        // i not over n - (k-comb.size()) + 1
        for(int i=start; i<= n - (k-comb.size()) + 1; i++){
            comb.add(i);
            generateCombinations(n,k, i+1, comb);
            comb.remove(comb.size()-1);
        }

    }

    public List<List<Integer>> combine(int n, int k) {

        if(n <= 0 || k <=0 || k > n) return res;

        List<Integer> c = new LinkedList<>();
        generateCombinations(n,k,1, c);

        return res;

    }
}
