package com.company.tree;

/**
 * @author hans
 */
public class L0226InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if( root == null) return null;

        invertTree( root.left);
        invertTree( root.right);

        // swap tree

        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }



}
