package leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode00120Triangle {

    //      2
    //    3, 4
    //  6, 5, 7
    // 4, 1, 8, 3

//
//    [11]
//    [9, 10]
//    [7,  6, 10]
//    [4,  1,  8, 3]

    public static void print(List<List<Integer>> triangle){
        triangle.forEach(a -> System.out.println(a));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {

        int nextToLast = triangle.size()-2;

        for(int i=nextToLast; i >= 0; i--){
            for(int j=0; j  < triangle.get(i).size(); j++){
                int Min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                triangle.get(i).set(j, triangle.get(i).get(j) + Min);
                print(triangle);
            }
        }

        return triangle.get(0).get(0);
    }


    public static void main(String[] args) {

        int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};

        List triangleList = new ArrayList<List<Integer>>();
        for(int[] array : triangle){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0; i < array.length; i++){
                temp.add(array[i]);
            }
            triangleList.add(temp);
        }

        System.out.println(minimumTotal(triangleList));
    }
}
