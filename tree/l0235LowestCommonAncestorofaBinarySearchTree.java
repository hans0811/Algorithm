package com.hans.tree;

/**
 * @author hans
 */
public class l0235LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null ) return null;

        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);

        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);

        return root;



    }

}
