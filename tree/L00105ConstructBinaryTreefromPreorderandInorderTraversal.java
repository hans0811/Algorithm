package com.hans.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hans
 */
public class L00105ConstructBinaryTreefromPreorderandInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < preorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);

    }


    public static TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd,
                                     Map<Integer, Integer> map) {
        if(pStart > pEnd || iStart > iEnd) return null;

        // Find the root,
        TreeNode root = new TreeNode(preorder[pStart]);

        int index = map.get(root.val);

        int numsLeft = index - iStart;

//        while( preorder[pStart] != inorder[iStart + index]){
//            index++;
//        }

        System.out.println(root.val + " " + pStart + " " + pEnd + " " + iStart + " " + iEnd);

        root.left = buildTree(preorder, pStart+1, pStart+numsLeft,
                                inorder, iStart, index-1, map);

        root.right = buildTree(preorder, pStart+numsLeft+1, pEnd,
                                inorder, index+1, iEnd, map);

        return root;

    }


    public static void main(String[] args) {

        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        System.out.println(buildTree(preorder, inorder));

    }
}
