package algorithm.tree;

import common.TreeNode;

public class L001448CountGoodNodesInBinaryTree {

    public static int goodNodes(TreeNode root) {

        int res = 0;
        res += dfs( root, Integer.MIN_VALUE);

        return res;
    }

    public static int dfs(TreeNode root, int max){

        if( root == null ){
            return 0;
        }

        int res = 0;

        if ( root.val >= max){
            max = Math.max(max, root.val);
            res++;
        }

        return res + dfs(root.left, max) + dfs(root.right, max);

    }

    public static void main(String[] args) {

    }
}
