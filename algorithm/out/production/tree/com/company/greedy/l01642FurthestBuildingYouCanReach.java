package algorithm.greedy;

import java.util.PriorityQueue;

public class l01642FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i < heights.length-1; i++){
            int diff = heights[i+1] - heights[i];

            if (diff > 0){
                queue.offer(diff);
            }
            // if climb building more than ladders
            if(queue.size() > ladders){
                bricks -= queue.poll();
            }
            if(bricks < 0){
                return i;
            }
        }
        return heights.length - 1;
    }

    public static void main(String[] args) {

    }
}
