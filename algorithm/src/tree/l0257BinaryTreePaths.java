package tree;

import com.company.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hans
 */
public class l0257BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();

        if(root == null) return res;

        if(root.left == null && root.right == null){
            res.add(Integer.toString(root.val));
            return res;
        }


        List<String> l = binaryTreePaths(root.left);
        for(int i=0; i < l.size(); i++){
            res.add(Integer.toString(root.val) + "->" + l.get(i));
        }

        List<String> r = binaryTreePaths(root.right);
        for(int i=0; i < l.size(); i++){
            res.add(Integer.toString(root.val) + "->" + r.get(i));
        }

        return res;

    }
}
