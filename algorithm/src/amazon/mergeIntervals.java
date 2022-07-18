package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals {

    /**
     * 56
     * @param intervals
     * @return
     */
    public static int mergeIntervals(int[][] intervals ){

        if(intervals.length <= 1){
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        res.add(newInterval);

        for(int[] interval : intervals){
            if(interval[0] < newInterval[1]){
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }else{
                newInterval = interval;
                res.add(newInterval);
            }
        }

        return intervals.length - res.size();

    }

    public static void main(String[] args) {


        int[][] a1 =  {{1,2},{2,3},{3,5},{4,5}};

        System.out.println(mergeIntervals(a1));
    }
}
