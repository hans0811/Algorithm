package com.company.queue;

import com.company.common.TreeNode;

import java.util.*;

/**
 * @author hans
 */


public class l0102BinaryTreeLevelOrderTraversal {


    class CustomPair{
        public CustomPair() {
        }
        public CustomPair(int key, TreeNode node) {
            this.key = key;
            this.node = node;
        }

        private int key;
        private TreeNode node;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if( root == null) return res;

        Integer lv = 0;
        Map<Integer, TreeNode> map = new HashMap<>();

        Queue<CustomPair> q = new PriorityQueue<>();

        //CustomPair pair = new CustomPair();


        map.put(lv,root);


        q.add(new CustomPair(0, root));

        while( !q.isEmpty()){

            TreeNode node = q.peek().node;
            int level = q.peek().key;
            q.poll();

            if( level == res.size() ){
                res.add(new LinkedList<>());
            }

            res.get(level).add(Integer.valueOf(node.val));

            if(node.left != null){
                q.add(new CustomPair(level+1, node.left));
            }

            if(node.right != null){
                q.add(new CustomPair(level+1, node.right));
            }

        }
        return res;
    }

}
