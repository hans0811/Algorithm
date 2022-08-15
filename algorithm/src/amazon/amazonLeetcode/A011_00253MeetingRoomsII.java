package amazonLeetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class A011_00253MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals){
        if(intervals.length <= 1) return intervals.length;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int room = 0;

        for(int i=0; i < intervals.length; i++){
            pq.offer(intervals[i][1]);
            if(intervals[i][0] < pq.peek()){
                room++;
            }else{
                pq.poll();
            }
        }

        return room;

    }

    public static void main(String[] args) {
        int[][] time = {{0,30}, {5,10},{15,20},{25,35}, {1,2}};

        System.out.println(minMeetingRooms(time));
    }


}
