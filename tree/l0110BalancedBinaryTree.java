package com.hans.tree;

/**
 * @author hans
 */
public class l0110BalancedBinaryTree {

    public int height1(TreeNode root){

        if(root == null) return 0;

        return Math.max(height1(root.left), height1(root.right)) + 1;
    }


    public boolean isBalanced(TreeNode root) {

        if(root == null) return true;

        if(Math.abs((height1(root.left) - height1(root.right))) > 1) return false;

        return (isBalanced(root.left) && isBalanced(root.right));

    }

}
