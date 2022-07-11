package algorithm.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L000199BinaryTreeRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){


            int size = q.size();

            for(int i=0; i < size; i++){
                root = q.poll();

                if(root.left != null) {
                    q.add(root.left);
                }
                if(root.right != null) {
                    q.add(root.right);
                }

            }

            ans.add(root.val);
        }

        return ans;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);

        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(6);

        node.left.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        node.left.left.left = new TreeNode(5);
        node.left.left.right = new TreeNode(8);

        node.right.right.right = new TreeNode(1);

        System.out.println(rightSideView(node));
    }

}

