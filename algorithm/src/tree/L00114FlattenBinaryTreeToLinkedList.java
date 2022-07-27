package algorithm.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L00114FlattenBinaryTreeToLinkedList {


    public static void flatten(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return;

        Stack<TreeNode> stk = new Stack<>();

        stk.push(root);

        while(stk.size() > 0){

            TreeNode temp = stk.peek();
            res.add(temp.val);
            stk.pop();

            if(temp.right != null ) stk.push(temp.right);
            if(temp.left != null) stk.push(temp.left);
        }

        TreeNode ans = new TreeNode();
        ans.left = root;

        for(int i=1; i< res.size(); i++){
            TreeNode temp = new TreeNode(res.get(i));
            root.right = temp;
            root.left = null;
            root = root.right;
        }

    }

    // 1, 2, 5, 3, 4,
    public static void flattenLoop(TreeNode root){
        TreeNode node = root;
        while (node != null){
            TreeNode left = node.left; // 2
            TreeNode right = node.right;// 5

            if(left != null ){
                TreeNode temp = left; // 2 3,4
                while(temp.right != null){ // 4
                    temp = temp.right; // 4
                }
                temp.right = right;// 4, 5
                node.right = left; // 1 2
                node.left = null;
            }
            node = node.right;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);

        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);

//
//        node.right.right = new TreeNode(7);
//
//        node.left.left.left = new TreeNode(5);
//        node.left.left.right = new TreeNode(8);
//
//        node.right.right.right = new TreeNode(1);
        flatten(node);

        while(node != null ){

            System.out.println(node.val);
            node = node.right;
        }

    }

}
