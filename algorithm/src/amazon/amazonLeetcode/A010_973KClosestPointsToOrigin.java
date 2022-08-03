package amazonLeetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class A010_973KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a,b) ->  (a[0]*a[0] + a[1]*a[1] ) - ( b[0]*b[0] + b[1]*b[1]) );

        int[][] res = new int[k][];
        for(int i=0; i < k; i++){
            res[i] = new int[] {points[i][0], points[i][1]};
        }


        return res;
    }

    public int[][] kClosestPriorityQueue(int[][] points, int K) {
        PriorityQueue<int[]> data = new PriorityQueue<>(K,
                (int[] a1, int[] a2) -> a2[0]*a2[0]+a2[1]*a2[1]-a1[0]*a1[0]-a1[1]*a1[1]);
        for (int[] point : points) {
            data.add(point);
            if (data.size() > K) {
                data.poll();
            }
        }
        return data.toArray(new int[K][2]);
    }

    private int dis(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    public static void main(String[] args) {
        int[][] points = {{-2,2}, {1,3}, {1,1}};
        kClosest(points, 1);
    }
}
