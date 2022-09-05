package tree;

import common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L00429NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        if( root == null ) return new ArrayList<List<Integer>>();

        List<List<Integer>> res = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while( !q.isEmpty() ){
            ArrayList<Integer> out = new ArrayList<>();

            for( int i= q.size(); i > 0; i--){
                Node temp = q.peek();
                q.poll();
                out.add(temp.val);
                if(!temp.children.isEmpty()){
                    for(Node a : temp.children){
                        q.add(a);
                    }
                }
            }

            res.add(out);
        }

        return res;
    }


}
