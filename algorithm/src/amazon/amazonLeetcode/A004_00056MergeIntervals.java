package amazonLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A004_00056MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return intervals;

        List<int[]> mergeIntervals = new ArrayList<>();
        Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0]));

        int[] currentInterval = intervals[0];

        mergeIntervals.add(currentInterval);

        for(int[] interval : intervals){

            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];

            int newStart = interval[0];
            int newEnd = interval[1];
            if(currentEnd >= newStart){
                currentInterval[1] = Math.max(currentEnd, newEnd);
            }else{
                currentInterval = interval;
                mergeIntervals.add(currentInterval);
            }
        }

        return mergeIntervals.toArray(new int[mergeIntervals.size()][]);
    }


}
