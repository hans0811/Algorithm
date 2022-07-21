package tree;

import com.company.common.TreeNode;

/**
 * @author hans
 */
public class l0100SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(q == null && p == null) return true;
        if(q == null || p == null) return false;

        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left)&&isSameTree(p.right,q.right);


    }
}
