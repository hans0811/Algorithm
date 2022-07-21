package tree;

import com.company.common.TreeNode;

/**
 * @author hans
 */
public class l0437PathSumIII {

    // Find path from root
    public int pathSum(TreeNode root, int targetSum) {

        if(root == null) return 0;

        int res = findPath( root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);

        return res;

    }

    // find path from node
    public int findPath(TreeNode root, int num){

        if(root == null) return 0;

        int res = 0;
        if(root.val == num){
            res++;
        }

        res += findPath(root.left, num - root.val);
        res += findPath(root.right, num - root.val);

        return res;
    }
}
