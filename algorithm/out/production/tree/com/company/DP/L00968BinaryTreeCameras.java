package leetcode.DP;

import common.TreeNode;

public class L00968BinaryTreeCameras {

    public static int res = 0;
    public static int minCameraCover(TreeNode root) {

        int node = findNode(root);

        if(node == 0){
            ++res;
        }

        return res;
    }

    public static int findNode(TreeNode node){
        if(node == null) return 1;
        int l = findNode(node.left);
        int r = findNode(node.right);

        if(l == 0 || r == 0){
            res++;
            return 2;
        }

        if(l == 1 && r == 1){
            return 0;
        }


        if(l + r >= 3){
            return 1;
        }

        return -1;

    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        boolean up = true;
        boolean down = false;

        for(int i=1; i < arr.length; i++){

            if( down == true && arr[i] > arr[i-1]){
                return false;
            }

            if( down == false && arr[i] < arr[i-1] ){
                down = true;
            }

            if( down == false && arr[i] <= arr[i-1]){
                return false;
            }



        }

        return true;


    }


    public static void main(String[] args) {
        TreeNode t3 = new TreeNode();
        TreeNode t2 = new TreeNode(0, t3, null);
        TreeNode t1 = new TreeNode(0, t2, null);

        //System.out.println(minCameraCover(t1));

        System.out.println(validMountainArray(new int[] {0,3,2,1}));


    }

}
