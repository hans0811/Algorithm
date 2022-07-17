package tree;

import com.company.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class l0144BinaryTreePreorderTraversal {

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;

        int leftMaxDepth = maxDepth(root.left);

        int rightMaxDepth=maxDepth(root.right);

        return Math.max(leftMaxDepth, rightMaxDepth) + 1;


    }
}
