package com.company;

import com.company.common.TreeNode;

public class Main {

    TreeNode last;
    public boolean isValidBST(TreeNode root){


        return false;
    }


    public static void main(String[] args) {
	// write your code here

        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(7);

        t2.setLeft(t3);
        t2.setRight(t1);

        System.out.println(t2);

    }
}
