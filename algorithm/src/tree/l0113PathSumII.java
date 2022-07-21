package tree;

import com.company.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hans
 */
public class l0113PathSumII {
    // https://stackoverflow.com/questions/51825663/why-res-addnew-arraylistlist-here
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();

        findPath( root, targetSum, res, path);

        return res;
    }

    public void findPath(TreeNode root, int targetSum, List<List<Integer>> r, List<Integer> p){

        if(root == null) return;

        p.add(root.val);

        if(targetSum == root.val && root.left==null && root.right==null){
            r.add(new LinkedList<>(p));
        }

        findPath(root.left, targetSum-root.val, r, p);
        findPath(root.right, targetSum-root.val, r, p);

        System.out.println();

        String a = "";


        p.remove(p.size() -1);

    }
}
